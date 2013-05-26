package com.daveayan.ark;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.objenesis.instantiator.ObjectInstantiator;
/**
 * Usage:
 * ArkUtils.get_value_on_field(Object target, String field_name)
 * ArkUtils.set_value_on_field(Object target, String field_name, Object value)
 * ArkUtils.public static Object instantiate(Class< ? > clazz)
 * 
 * @author daveayan
 *
 */
public class ArkUtils {
	
	private static boolean construct_from_this_object_Q(Object object) {
		if(object == null) {
			return false;
		}
		if(object instanceof Map) {
			Map< ?, ? > m = (Map< ?, ? >) object;
			Object value = m.get("class_name");
			if(value instanceof String) {
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object contruct_from_map(Map<String, Object> map) {
		if(! construct_from_this_object_Q(map)) {
			return map;
		}
		String class_name = (String) map.get("class_name");
		Object instantiated_object = instantiate(class_name);
		for(String key: map.keySet()) {
			if(StringUtils.equalsIgnoreCase(key, "class_name")) {
				continue;
			}
			Object value = map.get(key);
			if(construct_from_this_object_Q(value)) {
				Object complex_object = contruct_from_map((Map) value);
				set_value_on_field(instantiated_object, key, complex_object);
			} else if (value instanceof List){
				String collection_type = (String) ((Map) ((List) value).get(0)).get("collection_type");
				Collection collection = (Collection) instantiate_native(collection_type);
				for(int i = 1; i < ((List) value).size(); i++) {
					if(construct_from_this_object_Q(((List) value).get(i))) {
						collection.add(contruct_from_map((Map) ((List) value).get(i)));
					} else {
						collection.add(((List) value).get(i));
					}
				}
				set_value_on_field(instantiated_object, key, collection);
			} else {
				set_value_on_field(instantiated_object, key, value);
			}
		}
		return instantiated_object;
	}
	
	public static List<String> get_all_field_names_on(Class<?> target) {
		List<String> field_names = new ArrayList<String>();
		Object target_object = instantiate(target);
		List<Field> fields = getAllFieldsIn(target_object);
		for (Field field : fields) {
			if(field != null) {
				field_names.add(field.getType().toString());
			}
		}
		return field_names;
	}
	
	public static Object get_value_on_field(Object target, String field_name) {
		List<Field> fields = getAllFieldsIn(target);
		for (Field field : fields) {
			if (fieldNameIs(field, field_name)) {
				return getFieldValueSafely(target, field);
			}
		}
		return null;
	}
	
	public static Object set_value_on_field(Object target, String field_name, Object value) {
		List<Field> fields = getAllFieldsIn(target);
		for(Field field: fields) {
			if(StringUtils.equals(field.getName(), field_name)) {
				makeAccessible(field);
				try {
					field.set(target, value);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return target;
	}
	
	public static Object instantiate(String fully_qualified_class_name) {
		try {
			Class< ? > clazz = Class.forName(fully_qualified_class_name);
			return instantiate(clazz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Object instantiate_native(String fully_qualified_class_name) {
		try {
			return instantiate_native(Class.forName(fully_qualified_class_name));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object instantiate_native(Class < ? > clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object instantiate(Class< ? > clazz) {
		Objenesis objenesis = new ObjenesisStd();
		ObjectInstantiator thingyInstantiator = objenesis.getInstantiatorOf(clazz);
		return thingyInstantiator.newInstance();
	}
	
	private static List<Field> getAllFieldsIn(Object object) {
		List<Field> classes = new ArrayList<Field>();
		classes.addAll(Arrays.asList(object.getClass().getDeclaredFields()));
		Class<?> superclass = object.getClass().getSuperclass();
		while (superclass != null) {
			classes.addAll(Arrays.asList(superclass.getDeclaredFields()));
			superclass = superclass.getSuperclass();
		}

		return classes;
	}
	
	private static boolean fieldNameIs(Field field, String fieldName) {
		if (field == null || fieldName == null)
			return false;
		if (field.getName().trim().equals(fieldName.trim()))
			return true;
		return false;
	}
	
	private static Object getFieldValueSafely(Object object, Field field) {
		try {
			return getFieldValue(object, field);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private static Object getFieldValue(Object object, Field field) throws IllegalArgumentException, IllegalAccessException {
		if(isNotAccessible(field)) { makeAccessible(field); }
		return field.get(object);
	}
	
	private static boolean isAccessible(Field field) {
		return Modifier.isPublic(field.getModifiers());
	}
	
	private static boolean isNotAccessible(Field field) {
		return ! Modifier.isPublic(field.getModifiers());
	}

	private static void makeAccessible(Field field) {
		if (!isAccessible(field)) {
			field.setAccessible(true);
		}
	}
}

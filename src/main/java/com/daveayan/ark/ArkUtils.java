package com.daveayan.ark;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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
	
	public static Object instantiate(String json) {
		return null;
	}
	
	public static Object instantiate(Class< ? > clazz) {
		try {
			Constructor< ? > c = clazz.getDeclaredConstructor();
			c.setAccessible(true);
			return c.newInstance();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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

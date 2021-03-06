package com.daveayan.ark;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.daveayan.mirage.ReflectionUtils;
import com.daveayan.rjson.Rjson;
import com.daveayan.rjson.utils.RjsonUtil;
/**
 * What is Ark?
 *
 *
 * @author daveayan
 *
 */
public class Ark {
	private Object object_to_work_with;
	private String field_name_to_work_with;
	private StringBuffer unit_test_stub = new StringBuffer();

	public Ark as_json_in_file(String file_path_and_name) {
		Rjson rjson = RjsonUtil.completeSerializer();
		String json = rjson.toJson(object_to_work_with);
		File file = new File(file_path_and_name);
		try {
			System.out.println("Writing to " + file.getAbsolutePath());
			FileUtils.writeStringToFile(file, json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	public Ark as_json_in_folder(String file_path) {
		return this.as_json_in_file(file_path + "/" + object_to_work_with.getClass().getName());
	}

	public static Map<String, Object> construct_outline(Object object) {
		return null;
	}

	public static Object construct_from_json(String json) {
		return RjsonUtil.completeSerializer().toObject(json);
	}

	public static Object construct_from_json_file(String file_path_name) {
		File file = new File(file_path_name);
		try {
			return RjsonUtil.completeSerializer().toObject(FileUtils.readFileToString(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object construct_from_map(Map<String, Object> map) {
		if(! can_construct_from_this_object(map)) {
			return map;
		}
		String class_name = (String) map.get("class_name");
		Object instantiated_object = ReflectionUtils.objectFor(class_name);
		for(String key: map.keySet()) {
			if(StringUtils.equalsIgnoreCase(key, "class_name")) {
				continue;
			}
			Object value = map.get(key);
			if(can_construct_from_this_object(value)) {
				Object complex_object = construct_from_map((Map) value);
				ReflectionUtils.set_value_on_field(instantiated_object, key, complex_object);
			} else if (value instanceof List) {
				List this_list = (List) value;
				if(this_list.isEmpty()) {
					ReflectionUtils.set_value_on_field(instantiated_object, key, this_list);
				} else {
					String collection_type = (String) ((Map) this_list.get(0)).get("collection_type");
					Collection collection = new ArrayList();
					if(StringUtils.isNotBlank(collection_type)) {
						collection = (Collection) ReflectionUtils.objectFor(collection_type);
					}
					for(int i = 1; i < ((List) value).size(); i++) {
						if(can_construct_from_this_object(((List) value).get(i))) {
							collection.add(construct_from_map((Map) ((List) value).get(i)));
						} else {
							collection.add(((List) value).get(i));
						}
					}
					ReflectionUtils.set_value_on_field(instantiated_object, key, collection);
				}
			} else if (value instanceof Map) {
				Map this_map = (Map<String, Object>) value;
				Map new_map = new HashMap();
				String collection_type = (String) (this_map).get("collection_type");
				if(StringUtils.isNotBlank(collection_type)) {
					new_map = (Map) ReflectionUtils.objectFor(collection_type);
				}
				Iterator<String> this_map_keyset_iterator = this_map.keySet().iterator();
				while(this_map_keyset_iterator.hasNext()) {
					String new_map_key = this_map_keyset_iterator.next();
					Object new_map_value = this_map.get(new_map_key);
					if(can_construct_from_this_object(new_map_value)) {
						Object new_constructed_value = construct_from_map((Map) new_map_value);
						new_map.put(new_map_key, new_constructed_value);
					} else {
						new_map.put(new_map_key, new_map_value);
					}
				}
				ReflectionUtils.set_value_on_field(instantiated_object, key, new_map);
			} else {
				ReflectionUtils.set_value_on_field(instantiated_object, key, value);
			}
		}
		return instantiated_object;
	}

	public static Ark with(Object target) {
		return Ark.on(target);
	}

	public static Ark collect(Object target) {
		return Ark.on(target);
	}

	public static Ark on(Object target) {
		Ark a = new Ark();
		a.object_to_work_with = target;
		return a;
	}

	public Ark set(String field_name) {
		this.field_name_to_work_with = field_name;
		return this;
	}

	public Ark value(Object value_to_set) {
		ReflectionUtils.set_value_on_field(object_to_work_with, field_name_to_work_with, value_to_set);
		return this;
	}

	public Object get_value_on(String field_name) {
		return ReflectionUtils.get_value_on_field(object_to_work_with, field_name);
	}

	public Object get_final_object() {
		return object_to_work_with;
	}

	public Object instantiate(Class<?> clazz) {
		return ReflectionUtils.objectFor(clazz);
	}

	public Object instantiate(String full_package_class_name) {
		return ReflectionUtils.objectFor(full_package_class_name);
	}

	public Object call_method(String method_name, Object... parameters) {
		return ReflectionUtils.call_forcibly(object_to_work_with, method_name, parameters);
	}

	public Object call_method_and_collect(String method_name, Object... parameters) {
		return ReflectionUtils.call_forcibly(object_to_work_with, method_name, parameters);
	}

	public static Ark start_collection(String name) {
		Ark ark = new Ark();
		ark.unit_test_stub.append("public void test_" + name + "{");
		return ark;
	}

	public String complete_collection() {
		this.unit_test_stub.append("}");
		return unit_test_stub.toString();
	}

	private static boolean can_construct_from_this_object(Object object) {
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
}

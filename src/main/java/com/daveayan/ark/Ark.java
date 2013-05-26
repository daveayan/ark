package com.daveayan.ark;

import java.util.Map;

public class Ark {
	private Object object_to_work_with;
	private String field_name_to_work_with;
	
	public static Object contruct_from_map(Map<String, Object> map) {
		return ArkUtils.contruct_from_map(map);
	}
	
	public static Ark with(Object target) {
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
		ArkUtils.set_value_on_field(object_to_work_with, field_name_to_work_with, value_to_set);
		return this;
	}
	
	public Object get_value_on(String field_name) {
		return ArkUtils.get_value_on_field(object_to_work_with, field_name);
	}
	
	public Object get_final_object() {
		return object_to_work_with;
	}
	
	public Object instantiate(Class<?> clazz) {
		return ArkUtils.instantiate(clazz);
	}
	
	public Object instantiate(String full_package_class_name) {
		return ArkUtils.instantiate(full_package_class_name);
	}
}

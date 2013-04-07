package com.daveayan.ark;

import junit.framework.Assert;

import org.junit.Test;

import com.daveayan.ark.sample.A;
import com.daveayan.ark.sample.B;
import com.daveayan.ark.sample.C;

public class ArkUtils_get_value_on_field_Test {
	A a = new A();
	B b = new B();
	C c = new C();
	
	
	@Test
	public void test_object_a() {
		Assert.assertEquals(1, ArkUtils.get_value_on_field(a, "a_private_primitive_int"));
		Assert.assertEquals(2, ArkUtils.get_value_on_field(a, "a_protected_primitive_int"));
		Assert.assertEquals(3, ArkUtils.get_value_on_field(a, "a_public_primitive_int"));
		Assert.assertEquals(4, ArkUtils.get_value_on_field(a, "a_default_primitive_int"));
		
		Assert.assertEquals(5, ArkUtils.get_value_on_field(a, "a_private_object_int"));
		Assert.assertEquals(6, ArkUtils.get_value_on_field(a, "a_protected_object_int"));
		Assert.assertEquals(7, ArkUtils.get_value_on_field(a, "a_public_object_int"));
		Assert.assertEquals(8, ArkUtils.get_value_on_field(a, "a_default_object_int"));
	}
	
	@Test
	public void test_object_b() {
		Assert.assertEquals(1, ArkUtils.get_value_on_field(b, "a_private_primitive_int"));
		Assert.assertEquals(2, ArkUtils.get_value_on_field(b, "a_protected_primitive_int"));
		Assert.assertEquals(3, ArkUtils.get_value_on_field(b, "a_public_primitive_int"));
		Assert.assertEquals(4, ArkUtils.get_value_on_field(b, "a_default_primitive_int"));
		
		Assert.assertEquals(5, ArkUtils.get_value_on_field(b, "a_private_object_int"));
		Assert.assertEquals(6, ArkUtils.get_value_on_field(b, "a_protected_object_int"));
		Assert.assertEquals(7, ArkUtils.get_value_on_field(b, "a_public_object_int"));
		Assert.assertEquals(8, ArkUtils.get_value_on_field(b, "a_default_object_int"));
		
		Assert.assertEquals(9, ArkUtils.get_value_on_field(b, "b_private_primitive_int"));
		Assert.assertEquals(10, ArkUtils.get_value_on_field(b, "b_protected_primitive_int"));
		Assert.assertEquals(11, ArkUtils.get_value_on_field(b, "b_public_primitive_int"));
		Assert.assertEquals(12, ArkUtils.get_value_on_field(b, "b_default_primitive_int"));
		
		Assert.assertEquals(13, ArkUtils.get_value_on_field(b, "b_private_object_int"));
		Assert.assertEquals(14, ArkUtils.get_value_on_field(b, "b_protected_object_int"));
		Assert.assertEquals(15, ArkUtils.get_value_on_field(b, "b_public_object_int"));
		Assert.assertEquals(16, ArkUtils.get_value_on_field(b, "b_default_object_int"));
	}
}

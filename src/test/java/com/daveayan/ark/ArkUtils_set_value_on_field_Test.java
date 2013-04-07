package com.daveayan.ark;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.daveayan.ark.sample.A;
import com.daveayan.ark.sample.B;
import com.daveayan.ark.sample.C;

public class ArkUtils_set_value_on_field_Test {
	A a = null;
	B b = null;
	C c = null;
	
	@Before
	public void setup() {
		a = (A) ArkUtils.instantiate(A.class);
		b = (B) ArkUtils.instantiate(B.class);
		c = (C) ArkUtils.instantiate(C.class);
	}
	
	@Test
	public void test_object_a() {
		ArkUtils.set_value_on_field(a, "a_private_primitive_int", 101);
		ArkUtils.set_value_on_field(a, "a_protected_primitive_int", 102);
		ArkUtils.set_value_on_field(a, "a_public_primitive_int", 103);
		ArkUtils.set_value_on_field(a, "a_default_primitive_int", 104);
		
		ArkUtils.set_value_on_field(a, "a_private_object_int", 105);
		ArkUtils.set_value_on_field(a, "a_protected_object_int", 106);
		ArkUtils.set_value_on_field(a, "a_public_object_int", 107);
		ArkUtils.set_value_on_field(a, "a_default_object_int", 108);
		
		Assert.assertEquals(101, ArkUtils.get_value_on_field(a, "a_private_primitive_int"));
		Assert.assertEquals(102, ArkUtils.get_value_on_field(a, "a_protected_primitive_int"));
		Assert.assertEquals(103, ArkUtils.get_value_on_field(a, "a_public_primitive_int"));
		Assert.assertEquals(104, ArkUtils.get_value_on_field(a, "a_default_primitive_int"));
		
		Assert.assertEquals(105, ArkUtils.get_value_on_field(a, "a_private_object_int"));
		Assert.assertEquals(106, ArkUtils.get_value_on_field(a, "a_protected_object_int"));
		Assert.assertEquals(107, ArkUtils.get_value_on_field(a, "a_public_object_int"));
		Assert.assertEquals(108, ArkUtils.get_value_on_field(a, "a_default_object_int"));
	}
	
	@Test
	public void test_object_b() {
		ArkUtils.set_value_on_field(b, "a_private_primitive_int", 109);
		ArkUtils.set_value_on_field(b, "a_protected_primitive_int", 110);
		ArkUtils.set_value_on_field(b, "a_public_primitive_int", 111);
		ArkUtils.set_value_on_field(b, "a_default_primitive_int", 112);
		
		ArkUtils.set_value_on_field(b, "a_private_object_int", 113);
		ArkUtils.set_value_on_field(b, "a_protected_object_int", 114);
		ArkUtils.set_value_on_field(b, "a_public_object_int", 115);
		ArkUtils.set_value_on_field(b, "a_default_object_int", 116);
		
		ArkUtils.set_value_on_field(b, "b_private_primitive_int", 117);
		ArkUtils.set_value_on_field(b, "b_protected_primitive_int", 118);
		ArkUtils.set_value_on_field(b, "b_public_primitive_int", 119);
		ArkUtils.set_value_on_field(b, "b_default_primitive_int", 120);
		
		ArkUtils.set_value_on_field(b, "b_private_object_int", 121);
		ArkUtils.set_value_on_field(b, "b_protected_object_int", 122);
		ArkUtils.set_value_on_field(b, "b_public_object_int", 123);
		ArkUtils.set_value_on_field(b, "b_default_object_int", 124);
		
		Assert.assertEquals(109, ArkUtils.get_value_on_field(b, "a_private_primitive_int"));
		Assert.assertEquals(110, ArkUtils.get_value_on_field(b, "a_protected_primitive_int"));
		Assert.assertEquals(111, ArkUtils.get_value_on_field(b, "a_public_primitive_int"));
		Assert.assertEquals(112, ArkUtils.get_value_on_field(b, "a_default_primitive_int"));
		
		Assert.assertEquals(113, ArkUtils.get_value_on_field(b, "a_private_object_int"));
		Assert.assertEquals(114, ArkUtils.get_value_on_field(b, "a_protected_object_int"));
		Assert.assertEquals(115, ArkUtils.get_value_on_field(b, "a_public_object_int"));
		Assert.assertEquals(116, ArkUtils.get_value_on_field(b, "a_default_object_int"));
		
		Assert.assertEquals(117, ArkUtils.get_value_on_field(b, "b_private_primitive_int"));
		Assert.assertEquals(118, ArkUtils.get_value_on_field(b, "b_protected_primitive_int"));
		Assert.assertEquals(119, ArkUtils.get_value_on_field(b, "b_public_primitive_int"));
		Assert.assertEquals(120, ArkUtils.get_value_on_field(b, "b_default_primitive_int"));
		
		Assert.assertEquals(121, ArkUtils.get_value_on_field(b, "b_private_object_int"));
		Assert.assertEquals(122, ArkUtils.get_value_on_field(b, "b_protected_object_int"));
		Assert.assertEquals(123, ArkUtils.get_value_on_field(b, "b_public_object_int"));
		Assert.assertEquals(124, ArkUtils.get_value_on_field(b, "b_default_object_int"));
	}
}

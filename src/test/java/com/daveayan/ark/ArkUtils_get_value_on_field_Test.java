package com.daveayan.ark;

import static com.daveayan.ark.Ark.on;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.daveayan.ark.sample.A;
import com.daveayan.ark.sample.B;
import com.daveayan.ark.sample.C;
import com.daveayan.mirage.ReflectionUtils;

public class ArkUtils_get_value_on_field_Test {
	A a = null;
	B b = null;
	C c = null;
	
	A a1 = new A();
	B b1 = new B();
	C c1 = new C();
	
	@Before
	public void setup() {
		a = (A) ReflectionUtils.objectForClassForcibly(A.class);
		b = (B) ReflectionUtils.objectForClassForcibly(B.class);
		c = (C) ReflectionUtils.objectForClassForcibly(C.class);
	}
	
	@Test
	public void test_object_a() {
		Assert.assertEquals(0, on(a).get_value_on("a_private_primitive_int"));
		Assert.assertEquals(0, on(a).get_value_on("a_protected_primitive_int"));
		Assert.assertEquals(0, on(a).get_value_on("a_public_primitive_int"));
		Assert.assertEquals(0, on(a).get_value_on("a_default_primitive_int"));
		
		Assert.assertEquals(null, on(a).get_value_on("a_private_object_int"));
		Assert.assertEquals(null, on(a).get_value_on("a_protected_object_int"));
		Assert.assertEquals(null, on(a).get_value_on("a_public_object_int"));
		Assert.assertEquals(null, on(a).get_value_on("a_default_object_int"));
	}
	
	@Test
	public void test_object_b() {
		Assert.assertEquals(0, on(b).get_value_on("a_private_primitive_int"));
		Assert.assertEquals(0, on(b).get_value_on("a_protected_primitive_int"));
		Assert.assertEquals(0, on(b).get_value_on("a_public_primitive_int"));
		Assert.assertEquals(0, on(b).get_value_on("a_default_primitive_int"));
		
		Assert.assertEquals(null, on(b).get_value_on("a_private_object_int"));
		Assert.assertEquals(null, on(b).get_value_on("a_protected_object_int"));
		Assert.assertEquals(null, on(b).get_value_on("a_public_object_int"));
		Assert.assertEquals(null, on(b).get_value_on("a_default_object_int"));
		
		Assert.assertEquals(0, on(b).get_value_on("b_private_primitive_int"));
		Assert.assertEquals(0, on(b).get_value_on("b_protected_primitive_int"));
		Assert.assertEquals(0, on(b).get_value_on("b_public_primitive_int"));
		Assert.assertEquals(0, on(b).get_value_on("b_default_primitive_int"));
		
		Assert.assertEquals(null, on(b).get_value_on("b_private_object_int"));
		Assert.assertEquals(null, on(b).get_value_on("b_protected_object_int"));
		Assert.assertEquals(null, on(b).get_value_on("b_public_object_int"));
		Assert.assertEquals(null, on(b).get_value_on("b_default_object_int"));
	}
	
	@Test
	public void test_object_a1() {
		Assert.assertEquals(1, ReflectionUtils.get_value_on_field(a1, "a_private_primitive_int"));
		Assert.assertEquals(2, ReflectionUtils.get_value_on_field(a1, "a_protected_primitive_int"));
		Assert.assertEquals(3, ReflectionUtils.get_value_on_field(a1, "a_public_primitive_int"));
		Assert.assertEquals(4, ReflectionUtils.get_value_on_field(a1, "a_default_primitive_int"));
		
		Assert.assertEquals(5, ReflectionUtils.get_value_on_field(a1, "a_private_object_int"));
		Assert.assertEquals(6, ReflectionUtils.get_value_on_field(a1, "a_protected_object_int"));
		Assert.assertEquals(7, ReflectionUtils.get_value_on_field(a1, "a_public_object_int"));
		Assert.assertEquals(8, ReflectionUtils.get_value_on_field(a1, "a_default_object_int"));
	}
	
	@Test
	public void test_object_b1() {
		Assert.assertEquals(1, on(b1).get_value_on("a_private_primitive_int"));
		Assert.assertEquals(2, on(b1).get_value_on("a_protected_primitive_int"));
		Assert.assertEquals(3, on(b1).get_value_on("a_public_primitive_int"));
		Assert.assertEquals(4, on(b1).get_value_on("a_default_primitive_int"));
		
		Assert.assertEquals(5, on(b1).get_value_on("a_private_object_int"));
		Assert.assertEquals(6, on(b1).get_value_on("a_protected_object_int"));
		Assert.assertEquals(7, on(b1).get_value_on("a_public_object_int"));
		Assert.assertEquals(8, on(b1).get_value_on("a_default_object_int"));
		
		Assert.assertEquals(9, on(b1).get_value_on("b_private_primitive_int"));
		Assert.assertEquals(10, on(b1).get_value_on("b_protected_primitive_int"));
		Assert.assertEquals(11, on(b1).get_value_on("b_public_primitive_int"));
		Assert.assertEquals(12, on(b1).get_value_on("b_default_primitive_int"));
		
		Assert.assertEquals(13, on(b1).get_value_on("b_private_object_int"));
		Assert.assertEquals(14, on(b1).get_value_on("b_protected_object_int"));
		Assert.assertEquals(15, on(b1).get_value_on("b_public_object_int"));
		Assert.assertEquals(16, on(b1).get_value_on("b_default_object_int"));
	}
}

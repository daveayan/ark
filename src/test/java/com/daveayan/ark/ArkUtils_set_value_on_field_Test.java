package com.daveayan.ark;

import static com.daveayan.ark.Ark.on;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.daveayan.ark.sample.A;
import com.daveayan.ark.sample.B;
import com.daveayan.ark.sample.C;
import com.daveayan.mirage.ReflectionUtils;
public class ArkUtils_set_value_on_field_Test {
	A a = null;
	B b = null;
	C c = null;
	
	@Before
	public void setup() {
		a = (A) ReflectionUtils.objectForClassForcibly(A.class);
		b = (B) ReflectionUtils.objectForClassForcibly(B.class);
		c = (C) ReflectionUtils.objectForClassForcibly(C.class);
	}
	
	@Test
	public void test_object_a() {
		on(a).set("a_private_primitive_int").value(101);
		
		on(a).set("a_private_primitive_int").value(101);
		on(a).set("a_protected_primitive_int").value(102);
		on(a).set("a_public_primitive_int").value(103);
		on(a).set("a_default_primitive_int").value(104);
		
		on(a).set("a_private_object_int").value(105);
		on(a).set("a_protected_object_int").value(106);
		on(a).set("a_public_object_int").value(107);
		on(a).set("a_default_object_int").value(108);
		
		Assert.assertEquals(101, ReflectionUtils.get_value_on_field(a, "a_private_primitive_int"));
		Assert.assertEquals(102, ReflectionUtils.get_value_on_field(a, "a_protected_primitive_int"));
		Assert.assertEquals(103, ReflectionUtils.get_value_on_field(a, "a_public_primitive_int"));
		Assert.assertEquals(104, ReflectionUtils.get_value_on_field(a, "a_default_primitive_int"));
		
		Assert.assertEquals(105, ReflectionUtils.get_value_on_field(a, "a_private_object_int"));
		Assert.assertEquals(106, ReflectionUtils.get_value_on_field(a, "a_protected_object_int"));
		Assert.assertEquals(107, ReflectionUtils.get_value_on_field(a, "a_public_object_int"));
		Assert.assertEquals(108, ReflectionUtils.get_value_on_field(a, "a_default_object_int"));
	}
	
	@Test
	public void test_object_b() {
		on(b).set("a_private_primitive_int").value(109);
		on(b).set("a_protected_primitive_int").value(110);
		on(b).set("a_public_primitive_int").value(111);
		on(b).set("a_default_primitive_int").value(112);
		
		on(b).set("a_private_object_int").value(113);
		on(b).set("a_protected_object_int").value(114);
		on(b).set("a_public_object_int").value(115);
		on(b).set("a_default_object_int").value(116);
		
		on(b).set("b_private_primitive_int").value(117);
		on(b).set("b_protected_primitive_int").value(118);
		on(b).set("b_public_primitive_int").value(119);
		on(b).set("b_default_primitive_int").value(120);
		
		on(b).set("b_private_object_int").value(121);
		on(b).set("b_protected_object_int").value(122);
		on(b).set("b_public_object_int").value(123);
		on(b).set("b_default_object_int").value(124);
		
		Assert.assertEquals(109, ReflectionUtils.get_value_on_field(b, "a_private_primitive_int"));
		Assert.assertEquals(110, ReflectionUtils.get_value_on_field(b, "a_protected_primitive_int"));
		Assert.assertEquals(111, ReflectionUtils.get_value_on_field(b, "a_public_primitive_int"));
		Assert.assertEquals(112, ReflectionUtils.get_value_on_field(b, "a_default_primitive_int"));
		
		Assert.assertEquals(113, ReflectionUtils.get_value_on_field(b, "a_private_object_int"));
		Assert.assertEquals(114, ReflectionUtils.get_value_on_field(b, "a_protected_object_int"));
		Assert.assertEquals(115, ReflectionUtils.get_value_on_field(b, "a_public_object_int"));
		Assert.assertEquals(116, ReflectionUtils.get_value_on_field(b, "a_default_object_int"));
		
		Assert.assertEquals(117, ReflectionUtils.get_value_on_field(b, "b_private_primitive_int"));
		Assert.assertEquals(118, ReflectionUtils.get_value_on_field(b, "b_protected_primitive_int"));
		Assert.assertEquals(119, ReflectionUtils.get_value_on_field(b, "b_public_primitive_int"));
		Assert.assertEquals(120, ReflectionUtils.get_value_on_field(b, "b_default_primitive_int"));
		
		Assert.assertEquals(121, ReflectionUtils.get_value_on_field(b, "b_private_object_int"));
		Assert.assertEquals(122, ReflectionUtils.get_value_on_field(b, "b_protected_object_int"));
		Assert.assertEquals(123, ReflectionUtils.get_value_on_field(b, "b_public_object_int"));
		Assert.assertEquals(124, ReflectionUtils.get_value_on_field(b, "b_default_object_int"));
	}
}

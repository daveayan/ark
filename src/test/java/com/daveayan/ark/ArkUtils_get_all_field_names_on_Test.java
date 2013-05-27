package com.daveayan.ark;

import org.junit.Test;

import com.daveayan.ark.sample.A;
import com.daveayan.ark.sample.B;
import com.daveayan.ark.sample.C;
import com.daveayan.mirage.ReflectionUtils;

public class ArkUtils_get_all_field_names_on_Test {
	@Test
	public void test_em() {
		System.out.println(ReflectionUtils.get_all_field_names_on(A.class));
		System.out.println(ReflectionUtils.get_all_field_names_on(B.class));
		System.out.println(ReflectionUtils.get_all_field_names_on(C.class));
	}
}

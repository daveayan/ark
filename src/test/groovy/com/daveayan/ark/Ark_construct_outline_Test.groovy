package com.daveayan.ark

import org.junit.Test
import static com.daveayan.ark.Ark.*

class Ark_construct_outline_Test {
	@Test
	public void returns_null_when_input_is_null() {
		def actual_object = construct_outline(null)
		assert null == actual_object
	}
	
	@Test
	public void returns_null_when_input_a_fully_loaded_object() {
		def actual_object = construct_outline(null)
		assert null == actual_object
	}
}

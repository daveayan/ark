package com.daveayan.ark.sample.ark1domain;

public class Service1 {
	public Value service1_multiply(Value a, Value b) {
		Value v = new Value();
		v.value = a.value * b.value;
		return v;
	}

	public Value service1_divide(Value a, Value b) {
		Value v = new Value();
		v.value = a.value / b.value;
		return v;
	}
}

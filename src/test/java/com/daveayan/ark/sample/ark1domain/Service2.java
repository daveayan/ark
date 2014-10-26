package com.daveayan.ark.sample.ark1domain;

public class Service2 {
	public Value service2_add(Value a, Value b) {
		Value v = new Value();
		v.value = a.value + b.value;
		return v;
	}

	public Value service2_subtract(Value a, Value b) {
		Value v = new Value();
		v.value = a.value - b.value;
		return v;
	}
}

package com.daveayan.ark.sample.ark1domain;

import com.daveayan.ark.Ark1;

public class Controller {
	public Service1 s1 = new Service1();
	public Service2 s2 = new Service2();

	public Value method1(Value value1, Value value2, int operation) {
		Ark1 ark1 = Ark1.testing(this, "method1", ".");

		ark1.captureInputParameter(value1);
		ark1.captureInputParameter(value2);
		ark1.captureInputParameter(operation);

		Value value = new Value();
		value1.value += 1;
		value2.value += 1;

		if(operation == 1) {
			value = (Value) ark1.executeAndCaptureForMock(s1, "service1_multiply", value1, value2);
//			value = s1.service1_multiply(value1, value2);
		} else if(operation == 2) {
			value = (Value) ark1.executeAndCaptureForMock(s1, "service1_divide", value1, value2);
//			value = s1.service1_divide(value1, value2);
		} else if(operation == 3) {
			value = (Value) ark1.executeAndCaptureForMock(s2, "service2_add", value1, value2);
//			value = s2.service2_add(value1, value2);
		} else if(operation == 4) {
			value = (Value) ark1.executeAndCaptureForMock(s2, "service2_subtract", value1, value2);
//			value = s2.service2_subtract(value1, value2);
		}
		ark1.captureExpectedReturnObject(value);
		System.out.println(ark1.getTestScript());
		return value;
	}

	public Value method2(Value value1, Value value2, int operation) {
		Value value = new Value();
		value1.value += 1;
		value2.value += 1;
		if(operation == 1) {
			value = s1.service1_multiply(value1, value2);
		} else if(operation == 2) {
			value = s1.service1_divide(value1, value2);
		} else if(operation == 3) {
			value = s2.service2_add(value1, value2);
		} else if(operation == 4) {
			value = s2.service2_subtract(value1, value2);
		}
		return value;
	}
}

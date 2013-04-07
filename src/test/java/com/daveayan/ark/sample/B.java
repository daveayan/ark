package com.daveayan.ark.sample;

public class B extends A {
	private int b_private_primitive_int = 9;
	protected int b_protected_primitive_int = 10;
	public int b_public_primitive_int = 11;
	/*default*/ int b_default_primitive_int = 12;
	
	private Integer b_private_object_int = 13;
	protected Integer b_protected_object_int = 14;
	public Integer b_public_object_int = 15;
	/*default*/ Integer b_default_object_int = 16;
	
	private C c_private = null;
	protected C c_protected = null;
	public C c_public = null;
	/*default*/ C c_default = null;
}

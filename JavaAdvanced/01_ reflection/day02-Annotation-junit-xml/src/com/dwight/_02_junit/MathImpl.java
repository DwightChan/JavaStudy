package com.dwight._02_junit;

public class MathImpl implements IMath {
	
	@Override
	public int add(int a, int b) {
		
		return a + b;
	}

	@Override
	public int divid(int a, int b) {
		return a / b;
	}

}

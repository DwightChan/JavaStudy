package com._520it._02_contructor;

import java.util.Arrays;

public class User {
	public User() {
		
	}

	public User(String name) {
		System.out.println("name" + name);
	}

	private User(String name, Integer age) {
		System.out.println("name" + name + " + age : " + age);
	}
	public String doWork1() {
		return "doWork1";
	}
	public String doWork2(String method) {
		return "doWork2 : " + method;
	}
	private String doWork3(String method, Integer age) {
		return "doWork3 : " + method + " + age + " + age;
	}
	public static void staticMethod(String name) {
		System.out.println("staticMethod(String name)");
	} 
	public void doWork4(int... param) {
		System.out.println(Arrays.asList(param));
	}
	public void doWork5(String... param) {
		System.out.println(Arrays.asList(param));
	}
}

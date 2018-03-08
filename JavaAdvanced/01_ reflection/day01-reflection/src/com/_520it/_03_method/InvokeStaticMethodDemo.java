package com._520it._03_method;

import java.lang.reflect.Method;

import com._520it._02_contructor.User;

// 使用反射调用方法的细节
public class InvokeStaticMethodDemo {
	// 
	public static void main(String[] args) throws Exception {
		// 1. 获取 class 实例
		Class clz = User.class;
		// 2. 获取方法对象 staticMethod(String name) {
		Method m = clz.getMethod("staticMethod", String.class);
		// 3. 调用方法, 如果方法是静态方法, 那么调用的时候就直接将
		m.invoke(null, "sdfasd");
		
		System.out.println("----------------------------");
		// doWork4(int... param) {
		Method m2 = clz.getMethod("doWork4", int[].class);
		System.out.println(m2);
		//
		//m2.invoke(clz.newInstance(), 1, 2, 3, 4, 5); //java.lang.IllegalArgumentException: wrong number of arguments
		// 方法一
		//m2.invoke(clz.newInstance(), new int[] { 1, 2, 3, 4, 5} );
		// 通用方式
		m2.invoke(clz.newInstance(), new Object[] {new int[] { 1, 2, 3, 4, 5}} );
		System.out.println("----------------------------");
		
		// 调用可变参数方法, 将参数封装到一个数组中
		// doWork5(String... param) {
		Method m3 = clz.getMethod("doWork5", String[].class);
		System.out.println(m3);
		//m3.invoke(clz.newInstance(), new String[] {"a","b"}); //java.lang.IllegalArgumentException: wrong number of arguments
		m3.invoke(clz.newInstance(), new Object[] {new String[] {"a","b"}});
		
		
	}
}

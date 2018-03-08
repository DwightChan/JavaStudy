package com._520it._03_method;

import java.lang.reflect.Method;

import com._520it._02_contructor.User;

// ʹ�÷�����÷�����ϸ��
public class InvokeStaticMethodDemo {
	// 
	public static void main(String[] args) throws Exception {
		// 1. ��ȡ class ʵ��
		Class clz = User.class;
		// 2. ��ȡ�������� staticMethod(String name) {
		Method m = clz.getMethod("staticMethod", String.class);
		// 3. ���÷���, ��������Ǿ�̬����, ��ô���õ�ʱ���ֱ�ӽ�
		m.invoke(null, "sdfasd");
		
		System.out.println("----------------------------");
		// doWork4(int... param) {
		Method m2 = clz.getMethod("doWork4", int[].class);
		System.out.println(m2);
		//
		//m2.invoke(clz.newInstance(), 1, 2, 3, 4, 5); //java.lang.IllegalArgumentException: wrong number of arguments
		// ����һ
		//m2.invoke(clz.newInstance(), new int[] { 1, 2, 3, 4, 5} );
		// ͨ�÷�ʽ
		m2.invoke(clz.newInstance(), new Object[] {new int[] { 1, 2, 3, 4, 5}} );
		System.out.println("----------------------------");
		
		// ���ÿɱ��������, ��������װ��һ��������
		// doWork5(String... param) {
		Method m3 = clz.getMethod("doWork5", String[].class);
		System.out.println(m3);
		//m3.invoke(clz.newInstance(), new String[] {"a","b"}); //java.lang.IllegalArgumentException: wrong number of arguments
		m3.invoke(clz.newInstance(), new Object[] {new String[] {"a","b"}});
		
		
	}
}

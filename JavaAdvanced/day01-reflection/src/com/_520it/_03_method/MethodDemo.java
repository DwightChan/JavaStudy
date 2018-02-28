package com._520it._03_method;

import com._520it._02_contructor.User;
import java.lang.reflect.Method;

// ʹ�÷����ȡ����
public class MethodDemo {
	public static void main(String[] args) throws Exception, SecurityException {
		// 1. ��ȡ user �� classʵ��
		Class clz = User.class;
		// 2. ��ȡ��������
		// ��ȡ���еĹ�������, ���ܻ�ȡ���̳еõ��ķ���
		Method[] methods = clz.getMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		// ��ȡָ���ķ���, Ҫ��ȷ��ָ������һ������, ��ô����Ҫ������ķ���ǩ����ʲô?
		// ����ǩ��=��������+�����б�(�����ĸ��� , ���� , ˳��)
		// public String doWork1()
		Method m = clz.getMethod("doWork2", String.class);
		System.out.println(m);
		Method m2 = clz.getMethod("toString");
		System.out.println(m2);
		System.out.println("----------------------------");
		/// ��ȡ�����е����з���
		Method[] methods2 = clz.getDeclaredMethods();
		for (Method method : methods2) {
			System.out.println(method);
		}
		System.out.println("----------------------------");
		// ��ȡָ���ķ��� 
		Method m3 = clz.getDeclaredMethod("doWork3", String.class, Integer.class);
		System.out.println(m3);
	}
}

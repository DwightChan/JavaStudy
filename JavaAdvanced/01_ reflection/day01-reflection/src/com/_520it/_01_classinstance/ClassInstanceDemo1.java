package com._520it._01_classinstance;

import java.util.Date;

public class ClassInstanceDemo1 {
	public static void main(String[] args) throws Exception {
		// 1. ����.class (����һ���ֽ���)
		Class clz = Date.class;
		// 2. class.forName(String className);����һ�����Ȩ�޶��������� Class ����; 
		Class clz2 = Class.forName("java.util.Date");
		System.out.println(clz2.getName()); // java.util.Date
		System.out.println(clz2.getSimpleName()); // Date
		// 3. ÿ�������� getClass() ����: obj.getClass();���ض������ʵ����;
		Date d = new Date();
		Class clz3 = d.getClass();
		System.out.println("----------------------------");
		System.out.println(clz == clz2);
		System.out.println(clz == clz3);
		
		// 
	}
}

package com._520it._01_classinstance;

import java.util.Date;

public class ClassInstanceDemo1 {
	public static void main(String[] args) throws Exception {
		// 1. 类型.class (就是一份字节码)
		Class clz = Date.class;
		// 2. class.forName(String className);根据一个类的权限定名来构建 Class 对象; 
		Class clz2 = Class.forName("java.util.Date");
		System.out.println(clz2.getName()); // java.util.Date
		System.out.println(clz2.getSimpleName()); // Date
		// 3. 每个对象都有 getClass() 方法: obj.getClass();返回对象的真实类型;
		Date d = new Date();
		Class clz3 = d.getClass();
		System.out.println("----------------------------");
		System.out.println(clz == clz2);
		System.out.println(clz == clz3);
		
		// 
	}
}

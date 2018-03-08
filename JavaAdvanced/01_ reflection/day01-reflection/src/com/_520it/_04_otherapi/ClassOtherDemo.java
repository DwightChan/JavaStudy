package com._520it._04_otherapi;

import java.lang.reflect.Modifier;

import com._520it._02_contructor.User;

// 放射中其他常用个 API
public class ClassOtherDemo {
	public static void main(String[] args) {
		Class clz = User.class;
		Package package1 = clz.getPackage();
		System.out.println(package1.getName());
		
		// 获取类的父类
		Class obj = clz.getSuperclass();
		System.out.println(obj);
		
		// 获取 user 类的访问权限
		int ret = clz.getModifiers();
		System.out.println(ret); // 1
		System.out.println(Modifier.toString(ret)); // public
		
		// 判断当前类是否是枚举
		System.out.println(clz.isEnum()); 
		System.out.println(clz.isInterface());
		
	}
}

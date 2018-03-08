package com._520it._02_contructor;

import java.lang.reflect.Constructor;
import java.util.Iterator;

public class User {
	public User() {
	}

	public User(String name) {
		System.out.println("name" + name);
	}

	private User(String namem, Integer age) {
	}

}

public class ConstructorDemo {
	public static void main(String[] args) throws Exception, SecurityException {
		// 1. 获取 user 类的 class 实例
		Class clz = User.class;
		// 2.获取构造器, 该方法只能获取所有的公共构造器
		Constructor[] cons = clz.getConstructors();
		for (Constructor constructor : cons) {
			System.out.println(constructor);
		}
		System.out.println("----------------------------");
		// 3.获取指定的构造器 public User(String name)
		Constructor con = clz.getConstructor(String.class);
		System.out.println(con);
		// 获取指定的构造器 private User(String namem, Integer age)
		Constructor con2 = clz.getDeclaredConstructor(String.class, Integer.class);
		System.out.println(con2);
	}
}

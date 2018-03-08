package com._520it._02_contructor;

import java.lang.reflect.Constructor;

public class NewInstanceDemo {
	public static void main(String[] args) throws Exception {
		// 1. 获取 user 的 class 实例
		Class clz = Class.forName("com._520it._02_contructor.User");
		// 2. 获取构造器 public User(String name)
		Constructor cons = clz.getConstructor(String.class);
		// 3. 使用反射创建对象
		User u = (User)cons.newInstance("neld");
		System.out.println(u);
		
		// 使用私有的构造器创建对象
		Constructor cons2 = clz.getDeclaredConstructor(String.class, Integer.class);
		System.out.println(cons2);
		cons2.setAccessible(true);
		cons2.newInstance("asjfd", 12);
		
		// 在 class类中也提供了一个方法 newInstance();
		// 注意: 在该类中必须要有一个公共的无参构造器
		User u2 = (User)clz.newInstance();
		
	}
}

package com._520it._03_method;

import com._520it._02_contructor.User;
import java.lang.reflect.Method;

// 使用反射获取方法
public class MethodDemo {
	public static void main(String[] args) throws Exception, SecurityException {
		// 1. 获取 user 的 class实例
		Class clz = User.class;
		// 2. 获取方法对象
		// 获取类中的公共方法, 还能获取到继承得到的方法
		Method[] methods = clz.getMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		// 获取指定的方法, 要明确的指定是哪一个方法, 哪么必须要清楚他的方法签名是什么?
		// 方法签名=方法名称+参数列表(参数的个数 , 类型 , 顺序)
		// public String doWork1()
		Method m = clz.getMethod("doWork2", String.class);
		System.out.println(m);
		Method m2 = clz.getMethod("toString");
		System.out.println(m2);
		System.out.println("----------------------------");
		/// 获取本类中的所有方法
		Method[] methods2 = clz.getDeclaredMethods();
		for (Method method : methods2) {
			System.out.println(method);
		}
		System.out.println("----------------------------");
		// 获取指定的方法 
		Method m3 = clz.getDeclaredMethod("doWork3", String.class, Integer.class);
		System.out.println(m3);
	}
}

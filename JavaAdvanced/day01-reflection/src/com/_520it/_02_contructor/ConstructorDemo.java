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
		// 1. ��ȡ user ��� class ʵ��
		Class clz = User.class;
		// 2.��ȡ������, �÷���ֻ�ܻ�ȡ���еĹ���������
		Constructor[] cons = clz.getConstructors();
		for (Constructor constructor : cons) {
			System.out.println(constructor);
		}
		System.out.println("----------------------------");
		// 3.��ȡָ���Ĺ����� public User(String name)
		Constructor con = clz.getConstructor(String.class);
		System.out.println(con);
		// ��ȡָ���Ĺ����� private User(String namem, Integer age)
		Constructor con2 = clz.getDeclaredConstructor(String.class, Integer.class);
		System.out.println(con2);
	}
}

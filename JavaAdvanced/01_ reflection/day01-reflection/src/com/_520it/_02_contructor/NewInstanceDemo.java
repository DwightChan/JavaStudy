package com._520it._02_contructor;

import java.lang.reflect.Constructor;

public class NewInstanceDemo {
	public static void main(String[] args) throws Exception {
		// 1. ��ȡ user �� class ʵ��
		Class clz = Class.forName("com._520it._02_contructor.User");
		// 2. ��ȡ������ public User(String name)
		Constructor cons = clz.getConstructor(String.class);
		// 3. ʹ�÷��䴴������
		User u = (User)cons.newInstance("neld");
		System.out.println(u);
		
		// ʹ��˽�еĹ�������������
		Constructor cons2 = clz.getDeclaredConstructor(String.class, Integer.class);
		System.out.println(cons2);
		cons2.setAccessible(true);
		cons2.newInstance("asjfd", 12);
		
		// �� class����Ҳ�ṩ��һ������ newInstance();
		// ע��: �ڸ����б���Ҫ��һ���������޲ι�����
		User u2 = (User)clz.newInstance();
		
	}
}

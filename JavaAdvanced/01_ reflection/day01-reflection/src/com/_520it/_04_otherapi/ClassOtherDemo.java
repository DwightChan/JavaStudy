package com._520it._04_otherapi;

import java.lang.reflect.Modifier;

import com._520it._02_contructor.User;

// �������������ø� API
public class ClassOtherDemo {
	public static void main(String[] args) {
		Class clz = User.class;
		Package package1 = clz.getPackage();
		System.out.println(package1.getName());
		
		// ��ȡ��ĸ���
		Class obj = clz.getSuperclass();
		System.out.println(obj);
		
		// ��ȡ user ��ķ���Ȩ��
		int ret = clz.getModifiers();
		System.out.println(ret); // 1
		System.out.println(Modifier.toString(ret)); // public
		
		// �жϵ�ǰ���Ƿ���ö��
		System.out.println(clz.isEnum()); 
		System.out.println(clz.isInterface());
		
	}
}

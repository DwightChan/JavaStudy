package com.dwight._01_annotation;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// ģ�� Junit
public class JUnitTest {
	
	@MyBefore
	public void init () {
		System.out.println("init");
	}
	@MyAfter
	public void destroy() {
		System.out.println("destroy");
	}
	@MyTest
	public void add() {
		System.out.println("add");
	}
	@MyTest
	public void delete () {
		System.out.println("delete");
	}
	public static void main(String[] args) throws Exception {
		// ��ű� @MyBefore �����ķ���
		List<Method> beforeList = new ArrayList< >();
		// ��ű� @MyTest �����ķ���
		List<Method> testList = new ArrayList< >();
		// ��ű� @MyAfter �����ķ���
		List<Method> afterList = new ArrayList< >();
		
		// ��ȡ����ĵ��ֽ���
		Class clz = JUnitTest.class;
		// ��ȡ���еķ���
		Method[] ms = clz.getMethods();
		for (Method method : ms) {
			// �жϷ�������ʲôע��, �ͽ���ŵ��ĸ�������
			if(method.isAnnotationPresent(MyBefore.class)) {
				beforeList.add(method);
			}else if (method.isAnnotationPresent(MyTest.class)) {
				testList.add(method);
			}else if(method.isAnnotationPresent(MyAfter.class)){
				afterList.add(method);
			}
		}
		Object obj = clz.newInstance();
		// ���Ʒ�����ִ��˳��
		for (Method method : testList) {
			// ִ�в��Է���֮ǰҪִ�����е� beforeList �ķ���
			for (Method method2 : beforeList) {
				method2.invoke(obj);
			}
			// ִ�в��Է���
			method.invoke(obj);
			// ִ�����е� afterList �еķ���
			for (Method method2 : afterList) {
				method2.invoke(obj);
			}
		}
		
	}
}

package com.dwight._01_annotation;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// 模拟 Junit
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
		// 存放被 @MyBefore 所贴的方法
		List<Method> beforeList = new ArrayList< >();
		// 存放被 @MyTest 所贴的方法
		List<Method> testList = new ArrayList< >();
		// 存放被 @MyAfter 所贴的方法
		List<Method> afterList = new ArrayList< >();
		
		// 获取该类的的字节码
		Class clz = JUnitTest.class;
		// 获取所有的方法
		Method[] ms = clz.getMethods();
		for (Method method : ms) {
			// 判断方法上是什么注解, 就将其放到哪个集合中
			if(method.isAnnotationPresent(MyBefore.class)) {
				beforeList.add(method);
			}else if (method.isAnnotationPresent(MyTest.class)) {
				testList.add(method);
			}else if(method.isAnnotationPresent(MyAfter.class)){
				afterList.add(method);
			}
		}
		Object obj = clz.newInstance();
		// 控制方法的执行顺序
		for (Method method : testList) {
			// 执行测试方法之前要执行所有的 beforeList 的方法
			for (Method method2 : beforeList) {
				method2.invoke(obj);
			}
			// 执行测试方法
			method.invoke(obj);
			// 执行所有的 afterList 中的方法
			for (Method method2 : afterList) {
				method2.invoke(obj);
			}
		}
		
	}
}

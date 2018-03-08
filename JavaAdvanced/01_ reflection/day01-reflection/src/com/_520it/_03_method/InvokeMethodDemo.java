package com._520it._03_method;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com._520it._02_contructor.User;

// ʹ�÷�����÷���, ���� User ���е� public String doWork2(String name)
public class InvokeMethodDemo {
	public static void main(String[] args) throws Exception, SecurityException {
		// 1. ��ȡ User �� class ʵ��
		Class clz = User.class;
		// 2. ��ȡָ���ķ���
		Method m = clz.getMethod("doWork2", String.class);
		System.out.println(m);
		// 3. ���÷���
		String ret = (String) m.invoke(clz.newInstance(),"asdjflk");
		System.out.println(ret);
		System.out.println("----------------------------");
		// ����˽�з��� doWork3(String method, Integer age)
		Method m2 = clz.getDeclaredMethod("doWork3", String.class, Integer.class);
		System.out.println(m2);
		m2.setAccessible(true);
		
		// ����һ
		//String ret2 = (String) m2.invoke(clz.newInstance(), "sakjdf", 123);
		// ͨ�÷���
		String ret2 = (String) m2.invoke(clz.newInstance(), new Object[] { "sakjdf", 123});
		System.out.println(ret2);
		
		// ���֮ǰ������
		Object obj = new Date();
		Class clz2 = obj.getClass();
		Method m3 = clz2.getMethod("toLocaleString");
		System.out.println(m3.invoke(obj));
		
		// ���� Arrays ���еķ���, public static <T> List<T> asList(T... a) 
		Class clz3 = Arrays.class;
		Method[] methods = clz3.getMethods();
		for (Method method : methods) {
			//System.out.println(method);
		}
		Method m4 = clz3.getMethod("asList", Object[].class);
		System.out.println(m4);
		m4.invoke(null, new Object[] {new Object[] {"a", "b"}});
	}

}

package com._520it._07_properties;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.Exception;
import java.util.Properties;

public class LoadPropertiesDemo {

	public static void main(String[] args) throws Exception {
		load2();
	}
	// ʹ�þ���·���������ļ����ص��ڴ��� properties (���Ƽ�)
	public static void load1() throws Exception {
		FileInputStream fis = new FileInputStream("/Users/dwight/Desktop/github/JavaStudy/JavaAdvanced/day01-reflection/src/db.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String username = (String)pro.get("username");
		System.out.println(username);
		System.out.println(pro.getProperty("password"));
		
	}
	// ���·��
	public static void load2() throws Exception {
		// ����� classpath �ĸ�·�� classLoader
		
		// ��ȡָ���������ļ�
		System.out.println("---------------------------------");
		// ����һ
		//ClassLoader cl = Thread.currentThread().getContextClassLoader();
		//InputStream fis = cl.getResourceAsStream("db.properties");
		// ������
		ClassLoader cl = LoadPropertiesDemo.class.getClassLoader();
		InputStream fis = cl.getResourceAsStream("db.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String username = (String)pro.get("username");
		System.out.println(username);
		System.out.println(pro.getProperty("password"));
	}
}

package com._520it._07_properties;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.Exception;
import java.util.Properties;

public class LoadPropertiesDemo {

	public static void main(String[] args) throws Exception {
		load2();
	}
	// 使用绝对路径将配置文件加载到内存中 properties (不推荐)
	public static void load1() throws Exception {
		FileInputStream fis = new FileInputStream("/Users/dwight/Desktop/github/JavaStudy/JavaAdvanced/day01-reflection/src/db.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String username = (String)pro.get("username");
		System.out.println(username);
		System.out.println(pro.getProperty("password"));
		
	}
	// 相对路径
	public static void load2() throws Exception {
		// 相对于 classpath 的根路径 classLoader
		
		// 获取指定的配置文件
		System.out.println("---------------------------------");
		// 方法一
		//ClassLoader cl = Thread.currentThread().getContextClassLoader();
		//InputStream fis = cl.getResourceAsStream("db.properties");
		// 方法二
		ClassLoader cl = LoadPropertiesDemo.class.getClassLoader();
		InputStream fis = cl.getResourceAsStream("db.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String username = (String)pro.get("username");
		System.out.println(username);
		System.out.println(pro.getProperty("password"));
	}
}

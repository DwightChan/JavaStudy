package com._520it._05_singleton;

//实现单例设计, 饿汉式
public class JdbcUtil {
	// 事先创建好一个对象
	private static JdbcUtil instance = new JdbcUtil();
	// 将构造器私有化
	private JdbcUtil() {
		
	}
	
	// 向外界暴露一个公共的静态方法返回该对象
	public static JdbcUtil getInstance() {
		return instance;
	}
	// 工具方法
	
	public void doWork() {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) {
		System.out.println(getInstance() == getInstance());
	}
}

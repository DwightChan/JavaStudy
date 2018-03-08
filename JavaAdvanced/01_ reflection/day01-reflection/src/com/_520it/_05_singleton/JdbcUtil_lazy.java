package com._520it._05_singleton;


//实现单例设计, 懒汉式
public class JdbcUtil_lazy {
	// 事先创建好一个对象
	private static JdbcUtil_lazy instance = null;
	// 将构造器私有化
	private JdbcUtil() {
		
	}
	

//	public synchronized static JdbcUtil_lazy getInstance() {
//		if (instance == null) {
//			instance = new JdbcUtil_lazy();	
//		}
//
//		return instance;
//	}
	// 向外界暴露一个公共的静态方法返回该对象
	// 懒汉式要加同步锁, 避免线程安全问题
	// 在方法上枷锁, 表示当前方法只能同时被一个线程访问
	// 双重锁
	public synchronized static JdbcUtil_lazy getInstance() {
		if (instance == null) {
			synchronized (JdbcUtil_lazy.class) {
				if (instance == null) {
					instance = new JdbcUtil_lazy();	
				}
			}
		}
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

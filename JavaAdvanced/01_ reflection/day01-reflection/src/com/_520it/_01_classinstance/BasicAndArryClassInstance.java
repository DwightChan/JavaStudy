package com._520it._01_classinstance;

public class BasicAndArryClassInstance {
	public static void main(String[] args) {
		
		// 获取基本数据类型的 Class 实例是同一份吗?
		Class clz = int.class;
		Class clz2 = char.class;
		// 问题: int 和 Interger 的 Class 实例是同一份吗?
		// 基本数据类型和对应的包装类型不是同一种数据类型
		System.out.println(clz == Integer.class);

		System.out.println("--------------------");
		String[] str = {};
		String[] str2 = {"a","b"};
		System.out.println(String[].class == str2.getClass());
		System.out.println(Integer.TYPE); // 就是 int 类型
	}
	public void doWork(int age) {
		
	}
	public void doWork(Integer age) {
		
	}
	
}

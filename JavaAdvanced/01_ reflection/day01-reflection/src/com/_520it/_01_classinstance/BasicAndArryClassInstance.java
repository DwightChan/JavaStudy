package com._520it._01_classinstance;

public class BasicAndArryClassInstance {
	public static void main(String[] args) {
		
		// ��ȡ�����������͵� Class ʵ����ͬһ����?
		Class clz = int.class;
		Class clz2 = char.class;
		// ����: int �� Interger �� Class ʵ����ͬһ����?
		// �����������ͺͶ�Ӧ�İ�װ���Ͳ���ͬһ����������
		System.out.println(clz == Integer.class);

		System.out.println("--------------------");
		String[] str = {};
		String[] str2 = {"a","b"};
		System.out.println(String[].class == str2.getClass());
		System.out.println(Integer.TYPE); // ���� int ����
	}
	public void doWork(int age) {
		
	}
	public void doWork(Integer age) {
		
	}
	
}

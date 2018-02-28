package com._520it._05_singleton;

//ʵ�ֵ������, ����ʽ
public class JdbcUtil {
	// ���ȴ�����һ������
	private static JdbcUtil instance = new JdbcUtil();
	// ��������˽�л�
	private JdbcUtil() {
		
	}
	
	// ����籩¶һ�������ľ�̬�������ظö���
	public static JdbcUtil getInstance() {
		return instance;
	}
	// ���߷���
	
	public void doWork() {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) {
		System.out.println(getInstance() == getInstance());
	}
}

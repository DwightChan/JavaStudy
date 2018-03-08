package com._520it._05_singleton;


//ʵ�ֵ������, ����ʽ
public class JdbcUtil_lazy {
	// ���ȴ�����һ������
	private static JdbcUtil_lazy instance = null;
	// ��������˽�л�
	private JdbcUtil() {
		
	}
	

//	public synchronized static JdbcUtil_lazy getInstance() {
//		if (instance == null) {
//			instance = new JdbcUtil_lazy();	
//		}
//
//		return instance;
//	}
	// ����籩¶һ�������ľ�̬�������ظö���
	// ����ʽҪ��ͬ����, �����̰߳�ȫ����
	// �ڷ����ϼ���, ��ʾ��ǰ����ֻ��ͬʱ��һ���̷߳���
	// ˫����
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
	// ���߷���
	
	public void doWork() {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) {
		System.out.println(getInstance() == getInstance());
	}
}

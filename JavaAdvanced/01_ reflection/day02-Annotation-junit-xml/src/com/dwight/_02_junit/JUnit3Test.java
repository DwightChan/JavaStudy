package com.dwight._02_junit;

import junit.framework.TestCase;

public class JUnit3Test extends TestCase {
	public void testAdd() {
		System.out.println("testAdd");
	}

	public void add() {
		System.out.println("add");
	}

	public void testDelete() {
		System.out.println("testDelete");
	}

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		//super.setUp();
		System.out.println("��ʼ��");
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		//super.tearDown();
		System.out.println("����");
	}
//	// ����ʹ�ô���ģ�� test3 + ������ʾ
//	public void testUpdate() throws Exception {
//		System.out.println("testUpdate");
//	}
}

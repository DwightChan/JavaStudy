package com.dwight._01_annotation;

import java.awt.List;
import java.util.Date;
import java.util.Set;

// ��ʶע��
//@SuppressWarnings( {"all"} ) // ���о���
//@SuppressWarnings({ "unused", "rawtypes" }) // ��������, ��������������ͬ�ĵľ���
public class AnnotationDemo {
	// ��鵱ǰ�����Ƿ���������д�����еķ���
	@Override
	public String toString() {
		return "AnnotationDemo []";
	}
	//@SuppressWarnings({ "unused", "rawtypes" }) // ��������, ����������������ͬ�ĵľ���
	public void doWork1 () {
		@SuppressWarnings({ "unused", "rawtypes" }) // ��������, ֻ���������еľ���
		Set s = null;
		
		@SuppressWarnings("unused")
		List list = null;
		
	}
	public void doWork2 () {
		@SuppressWarnings({ "unused", "rawtypes" }) // ��������, ֻ���������еľ���
		Set s = null;
		
		@SuppressWarnings("unused")
		List list = null;
		
	}
	@SuppressWarnings("deprecation") // ��ʱ�� ����ȥ������
	public void doWork3 () {
		Date d = new Date();
		d.toLocaleString(); //
		
	}
	@Deprecated // ��������ʶΪ��ʱ�ķ���
	public void doWork4 () {
		@SuppressWarnings({ "unused", "rawtypes" }) // ��������, ֻ���������еľ���
		Set s = null;
		
		@SuppressWarnings("unused")
		List list = null;
		
	}
	
	/**
	 * @Deprecated 
	 */
	public void doWork5 () {
		@SuppressWarnings({ "unused", "rawtypes" }) // ��������, ֻ���������еľ���
		Set s = null;
		
		@SuppressWarnings("unused")
		List list = null;
		
	}
}

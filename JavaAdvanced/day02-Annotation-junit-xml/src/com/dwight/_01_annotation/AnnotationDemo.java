package com.dwight._01_annotation;

import java.awt.List;
import java.util.Date;
import java.util.Set;

// 认识注解
//@SuppressWarnings( {"all"} ) // 所有警告
//@SuppressWarnings({ "unused", "rawtypes" }) // 消除警告, 消除整个类中相同的的警告
public class AnnotationDemo {
	// 检查当前方法是否是用来复写父类中的方法
	@Override
	public String toString() {
		return "AnnotationDemo []";
	}
	//@SuppressWarnings({ "unused", "rawtypes" }) // 消除警告, 消除整个方法中相同的的警告
	public void doWork1 () {
		@SuppressWarnings({ "unused", "rawtypes" }) // 消除警告, 只能消除单行的警告
		Set s = null;
		
		@SuppressWarnings("unused")
		List list = null;
		
	}
	public void doWork2 () {
		@SuppressWarnings({ "unused", "rawtypes" }) // 消除警告, 只能消除单行的警告
		Set s = null;
		
		@SuppressWarnings("unused")
		List list = null;
		
	}
	@SuppressWarnings("deprecation") // 过时的 方法去除警告
	public void doWork3 () {
		Date d = new Date();
		d.toLocaleString(); //
		
	}
	@Deprecated // 将方法标识为过时的方法
	public void doWork4 () {
		@SuppressWarnings({ "unused", "rawtypes" }) // 消除警告, 只能消除单行的警告
		Set s = null;
		
		@SuppressWarnings("unused")
		List list = null;
		
	}
	
	/**
	 * @Deprecated 
	 */
	public void doWork5 () {
		@SuppressWarnings({ "unused", "rawtypes" }) // 消除警告, 只能消除单行的警告
		Set s = null;
		
		@SuppressWarnings("unused")
		List list = null;
		
	}
}

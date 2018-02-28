package com.dwight._01_annotation;

public class Child extends MyAnnoDemo{
	public static void main(String[] args) {
		Class clz = Child.class;
		System.out.println(clz.getAnnotation(MyAnno.class));
	}
}

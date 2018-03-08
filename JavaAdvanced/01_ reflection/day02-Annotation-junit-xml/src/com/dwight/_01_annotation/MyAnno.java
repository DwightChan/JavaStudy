package com.dwight._01_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
	String name() default "Neld"; // �ڽӿ��б�ʾһ������ķ���, ��ע���б�ʾ���� ���� Ĭ��ֵ
	//String name(); // û��Ĭ��ֵ 
	
	int age() default 18; // һ��ʹ�� integer ��װ����, ������ int �������� ����
	// ��������ֻ���ǣ�only primitive type(������������), String, Class, annotation, enumeration(ö��), arrays(����)
	
	String[] favs() default { "Java" , "C"};
	
	Gender sex() default Gender.BOY;
	
	String value() default "value"; // �ò����ڸ�ֵ��ʱ����Բ��� д������, ֻ������Ϊ value ���Բ�������

}

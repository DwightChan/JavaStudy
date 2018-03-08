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
	String name() default "Neld"; // 在接口中表示一个抽象的方法, 在注解中表示属性 并赋 默认值
	//String name(); // 没有默认值 
	
	int age() default 18; // 一般使用 integer 包装类型, 而不是 int 基本类型 但是
	// 数据类型只能是：only primitive type(基本数据类型), String, Class, annotation, enumeration(枚举), arrays(数组)
	
	String[] favs() default { "Java" , "C"};
	
	Gender sex() default Gender.BOY;
	
	String value() default "value"; // 该参数在赋值的时候可以不用 写属性名, 只有名字为 value 属性才是这样

}

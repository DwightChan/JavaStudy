package com.dwight._01_annotation;

import java.lang.annotation.Annotation;

//@MyAnno 已默认值
@MyAnno(name = "will") // 新值
public class MyAnnoDemo {
	public static void main(String[] args) {
		Class clz = MyAnnoDemo.class;
		if (clz.isAnnotationPresent(MyAnno.class)) {
			MyAnno ann = (MyAnno) clz.getAnnotation(MyAnno.class);
			System.out.println(ann);
			System.out.println(ann.age());
			System.out.println(ann.name());
			System.out.println(ann.favs());
			System.out.println(ann.sex());
			System.out.println(ann);

		}
		
		Annotation[] anns = clz.getAnnotations();
		for (Annotation annotation : anns) {
			System.out.println(annotation);
		}
	}
}

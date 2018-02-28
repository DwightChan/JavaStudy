package com._520it._06_tools;
//工具类: 当工具方法是静态方法时, 只需要将构造器私有化
//工具类: 当工具方法是非静态方法时, 使用单例设计模式来设计

//工具类: 当工具方法是静态方法时, 只需要将构造器私有化
//public class StringUtil {
//	// 判断一个字符串是否为空
//	public boolean hasLength(String str) {
//		// str.trim() // 去前后空格操作
////		if (str != null && !"".equals(str.trim()))) {
////			return true;
////		} 
////		return false;
//		
//		return str != null && !"".equals(str.trim());
//	}
//}
//工具类: 当工具方法是非静态方法时, 使用单例设计模式来设计
public enum StringUtil {
	INSTANCE;
	// 判断一个字符串是否为空
	public boolean hasLength(String str) {

		return str != null && !"".equals(str.trim());
	}
}
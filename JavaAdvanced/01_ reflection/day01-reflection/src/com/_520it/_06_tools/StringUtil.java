package com._520it._06_tools;
//������: �����߷����Ǿ�̬����ʱ, ֻ��Ҫ��������˽�л�
//������: �����߷����ǷǾ�̬����ʱ, ʹ�õ������ģʽ�����

//������: �����߷����Ǿ�̬����ʱ, ֻ��Ҫ��������˽�л�
//public class StringUtil {
//	// �ж�һ���ַ����Ƿ�Ϊ��
//	public boolean hasLength(String str) {
//		// str.trim() // ȥǰ��ո����
////		if (str != null && !"".equals(str.trim()))) {
////			return true;
////		} 
////		return false;
//		
//		return str != null && !"".equals(str.trim());
//	}
//}
//������: �����߷����ǷǾ�̬����ʱ, ʹ�õ������ģʽ�����
public enum StringUtil {
	INSTANCE;
	// �ж�һ���ַ����Ƿ�Ϊ��
	public boolean hasLength(String str) {

		return str != null && !"".equals(str.trim());
	}
}
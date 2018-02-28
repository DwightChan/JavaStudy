package com.dwight.dom4j;

import static org.junit.Assert.*;

import java.util.List;
import java.io.File;
import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.Element;
import org.junit.Test;





public class Dom4JTest {
	
	File f = new File("/Users/dwight/Desktop/github/JavaStudy/JavaAdvanced/day03-xml/NewFile.xml");
	@Test
	public void testGetDocument() throws Exception {
		  SAXReader reader = new SAXReader();
	      Document document = reader.read(f);
	      System.out.println(document);
	}
	
	//����1:��ѯ������ϵ�˵���Ϣ:
	@Test
	public void test1() throws Exception {
		Document doc = new SAXReader().read(f);
		Element root = doc.getRootElement();
		List<Element> elements = root.elements();
		for (Element el : elements) {
			// ��ȡ<linkman>�µ�������Ԫ��
			System.out.println(el.elementText("name"));
			System.out.println(el.elementText("email"));
			System.out.println(el.elementText("address"));
			System.out.println(el.elementText("group"));
		
		}
	}
	//����2:����һ����ϵ�˵���Ϣ:
	@Test
	public void test2() throws Exception {
		Document doc = new SAXReader().read(f);
		Element root = doc.getRootElement();
		
		// �ڸ�Ԫ���´���һ�� linkman Ԫ��
		Element linkman1 = root.addElement("linkman");
		// Ϊ linkman���Ԫ�� ����
		linkman1.addAttribute("id", "9527");
		// �� linkman Ԫ���´��� name email address group Ԫ��, �������ı�����
		linkman1.addElement("name").setText("���Ŵ�ѩ");
		linkman1.addElement("email").setText("123@123.com");
		linkman1.addElement("address").setText("����");
		linkman1.addElement("group").setText("����");
		// ͬ��
		// ����������ݸ�ʽ��
		OutputFormat format = OutputFormat.createPrettyPrint();
		// format.setEncoding()
		XMLWriter writer = new XMLWriter(new FileWriter(f), format);
		writer.write(doc);
		writer.close(); // �ַ�������ر�, ��ջ�����;
	}
}

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
	
	//需求1:查询所有联系人的信息:
	@Test
	public void test1() throws Exception {
		Document doc = new SAXReader().read(f);
		Element root = doc.getRootElement();
		List<Element> elements = root.elements();
		for (Element el : elements) {
			// 获取<linkman>下的所有子元素
			System.out.println(el.elementText("name"));
			System.out.println(el.elementText("email"));
			System.out.println(el.elementText("address"));
			System.out.println(el.elementText("group"));
		
		}
	}
	//需求2:新增一个联系人的信息:
	@Test
	public void test2() throws Exception {
		Document doc = new SAXReader().read(f);
		Element root = doc.getRootElement();
		
		// 在跟元素下创建一个 linkman 元素
		Element linkman1 = root.addElement("linkman");
		// 为 linkman添加元素 属性
		linkman1.addAttribute("id", "9527");
		// 在 linkman 元素下创建 name email address group 元素, 并设置文本内容
		linkman1.addElement("name").setText("西门吹雪");
		linkman1.addElement("email").setText("123@123.com");
		linkman1.addElement("address").setText("西门");
		linkman1.addElement("group").setText("武侠");
		// 同步
		// 将输出的数据格式化
		OutputFormat format = OutputFormat.createPrettyPrint();
		// format.setEncoding()
		XMLWriter writer = new XMLWriter(new FileWriter(f), format);
		writer.write(doc);
		writer.close(); // 字符流必须关闭, 清空缓冲区;
	}
}

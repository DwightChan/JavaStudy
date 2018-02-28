package com.dwight.dom;

import static org.junit.Assert.*;

import java.io.File;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

// 获取 Document 对象
public class DomTest {
	File f = new File("/Users/dwight/Desktop/github/JavaStudy/JavaAdvanced/day03-xml/NewFile.xml");

	@Test
	public void testGetDocument() throws Exception {
		// 1. 获取 xml 文件对象
		File f = new File("/Users/dwight/Desktop/github/JavaStudy/JavaAdvanced/day03-xml/NewFile.xml");
		// 2. 创建 DocumentBuilderFactory 对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 3.获取DocumentBuilder对象
		DocumentBuilder builder = factory.newDocumentBuilder();
		// 4.获取Document对象
		Document doc = builder.parse(f);
		System.out.println(doc);
	}

	@Test
	public void test1() throws Exception {
		// 1. 获取 xml 文件对象

		// 2. 创建 DocumentBuilderFactory 对象
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);

		// 2.获取Document文档根节点<contacts>
		Element root = doc.getDocumentElement();
		// 3.获取第二个联系人节点<linkman>
		NodeList nodeList = root.getElementsByTagName("linkman");
		Element linkmanE1 = (Element) nodeList.item(1);
		// 4.获取第二个联系人的<name>节点
		NodeList names = linkmanE1.getElementsByTagName("name");
		Node node = names.item(0);
		// 5.获取<name>中的文本
		String name = node.getTextContent();
		System.out.println(name);

		System.out.println(doc);
	}

	/// 修改第一个联系人的邮箱
	@Test
	public void test2() throws Exception {
		// 1.获取Document对象
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		// 2.获取Document文档根节点<contacts>
		Element root = doc.getDocumentElement();
		// 3.获取第一个联系人节点<linkman>
		NodeList linkmanEs = root.getElementsByTagName("linkman");
		Element linkmanE1 = (Element) linkmanEs.item(0);
		// 4.获取第一个联系人的<email>节点
		NodeList emailEs = linkmanE1.getElementsByTagName("email");
		Element emailE0 = (Element) emailEs.item(0);
		// 5.修改<email>节点的文本内容
		emailE0.setTextContent("neld@163.com");
		// 6.将数据同步到磁盘中
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer tf = factory.newTransformer();
		Source xmlSource = new DOMSource(doc); // Document 对象必须传进来
		Result outputTarget = new StreamResult(f); // 必须将 file 对象传进来
		tf.transform(xmlSource, outputTarget);
	}

	// 添加一个联系人
	@Test
	public void test3() throws Exception {
		// ①:获取Document文档对象.
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);

		// ②:获取XML的根元素对象.
		Element root = doc.getDocumentElement();

		// ③:创建一个<linkman>的XML片段:
		// Element linkmanEs = root.getElementsByTagName("linkman");
		// 1):创建五个新的元素:linkman,name,email,address,group.
		Element linkmanE1 = doc.createElement("linkman");
		Element nameE1 = doc.createElement("name");
		Element emailE1 = doc.createElement("email");
		Element addressE1 = doc.createElement("address");
		Element groupE1 = doc.createElement("group");

		// 2):为name,email,address,group设置文本内容.
		nameE1.setTextContent("张三");
		emailE1.setTextContent("123@123.com");
		addressE1.setTextContent("北京");
		groupE1.setTextContent("Dwight");
		// 3):把name,email,address,group元素作为linkman元素的儿子.
		linkmanE1.appendChild(nameE1);
		linkmanE1.appendChild(emailE1);
		linkmanE1.appendChild(addressE1);
		linkmanE1.appendChild(groupE1);
		// 4):把linkman元素作为根元素的儿子.
		root.appendChild(linkmanE1);
		// ④:把内存中的Document数据同步到磁盘的XML中.
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		Source xmlSource = new DOMSource(doc);
		Result outputTarget = new StreamResult(f);
		transformer.transform(xmlSource, outputTarget);
	}

	// 4、操作XML文件属性：设置/获取联系人的id属性
	@Test
	public void test4() throws Exception {
		// ①:获取Document文档对象.
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		// ②:获取XML的根元素对象.
		Element root = doc.getDocumentElement();
		// ③:获取第三个联系人
		Element linkmanE2 = (Element) root.getElementsByTagName("linkman").item(2);
		// ④:为当前的linkman设置id属性,属性值为9527.
		linkmanE2.setAttribute("id", "9527");
		// ⑤:把内存中的Document数据同步到磁盘的XML中.
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		Source xmlSource = new DOMSource(doc);
		Result outputTarget = new StreamResult(f);
		transformer.transform(xmlSource, outputTarget);
	}

	// 需求:5、删除指定元素节点：删除第三个联系人信息
	@Test
	public void test5() throws Exception {
		// ①:获取Document文档对象.
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		// ②:获取XML的根元素对象.
		Element root = doc.getDocumentElement();
		// ③:获取第三个linkman.
		Element linkmanE1 = (Element) root.getElementsByTagName("linkman").item(2);
		// ④:删除操作
		//root.removeChild(linkmanE1);
		linkmanE1.getParentNode().removeChild(linkmanE1);
		
		// ⑤:把内存中的Document数据同步到磁盘的XML中.
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		Source xmlSource = new DOMSource(doc);
		Result outputTarget = new StreamResult(f);
		transformer.transform(xmlSource, outputTarget);
	}
	// 需求:6、在内存中创建一个Document对象
	@Test
	public void test6() throws Exception {
		File f = new File("/Users/dwight/Desktop/github/JavaStudy/JavaAdvanced/day03-xml/student.xml");
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		doc.setXmlVersion("1.0");
		Element root = doc.createElement("students");
		// 将元素放到文档对象中;
		doc.appendChild(root);
		// 数据同步
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		Source xmlSource = new DOMSource(doc);
		Result outputTarget = new StreamResult(f);
		transformer.transform(xmlSource, outputTarget);
		
		
	}
}

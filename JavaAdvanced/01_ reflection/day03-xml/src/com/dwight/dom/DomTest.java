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

// ��ȡ Document ����
public class DomTest {
	File f = new File("/Users/dwight/Desktop/github/JavaStudy/JavaAdvanced/day03-xml/NewFile.xml");

	@Test
	public void testGetDocument() throws Exception {
		// 1. ��ȡ xml �ļ�����
		File f = new File("/Users/dwight/Desktop/github/JavaStudy/JavaAdvanced/day03-xml/NewFile.xml");
		// 2. ���� DocumentBuilderFactory ����
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 3.��ȡDocumentBuilder����
		DocumentBuilder builder = factory.newDocumentBuilder();
		// 4.��ȡDocument����
		Document doc = builder.parse(f);
		System.out.println(doc);
	}

	@Test
	public void test1() throws Exception {
		// 1. ��ȡ xml �ļ�����

		// 2. ���� DocumentBuilderFactory ����
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);

		// 2.��ȡDocument�ĵ����ڵ�<contacts>
		Element root = doc.getDocumentElement();
		// 3.��ȡ�ڶ�����ϵ�˽ڵ�<linkman>
		NodeList nodeList = root.getElementsByTagName("linkman");
		Element linkmanE1 = (Element) nodeList.item(1);
		// 4.��ȡ�ڶ�����ϵ�˵�<name>�ڵ�
		NodeList names = linkmanE1.getElementsByTagName("name");
		Node node = names.item(0);
		// 5.��ȡ<name>�е��ı�
		String name = node.getTextContent();
		System.out.println(name);

		System.out.println(doc);
	}

	/// �޸ĵ�һ����ϵ�˵�����
	@Test
	public void test2() throws Exception {
		// 1.��ȡDocument����
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		// 2.��ȡDocument�ĵ����ڵ�<contacts>
		Element root = doc.getDocumentElement();
		// 3.��ȡ��һ����ϵ�˽ڵ�<linkman>
		NodeList linkmanEs = root.getElementsByTagName("linkman");
		Element linkmanE1 = (Element) linkmanEs.item(0);
		// 4.��ȡ��һ����ϵ�˵�<email>�ڵ�
		NodeList emailEs = linkmanE1.getElementsByTagName("email");
		Element emailE0 = (Element) emailEs.item(0);
		// 5.�޸�<email>�ڵ���ı�����
		emailE0.setTextContent("neld@163.com");
		// 6.������ͬ����������
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer tf = factory.newTransformer();
		Source xmlSource = new DOMSource(doc); // Document ������봫����
		Result outputTarget = new StreamResult(f); // ���뽫 file ���󴫽���
		tf.transform(xmlSource, outputTarget);
	}

	// ���һ����ϵ��
	@Test
	public void test3() throws Exception {
		// ��:��ȡDocument�ĵ�����.
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);

		// ��:��ȡXML�ĸ�Ԫ�ض���.
		Element root = doc.getDocumentElement();

		// ��:����һ��<linkman>��XMLƬ��:
		// Element linkmanEs = root.getElementsByTagName("linkman");
		// 1):��������µ�Ԫ��:linkman,name,email,address,group.
		Element linkmanE1 = doc.createElement("linkman");
		Element nameE1 = doc.createElement("name");
		Element emailE1 = doc.createElement("email");
		Element addressE1 = doc.createElement("address");
		Element groupE1 = doc.createElement("group");

		// 2):Ϊname,email,address,group�����ı�����.
		nameE1.setTextContent("����");
		emailE1.setTextContent("123@123.com");
		addressE1.setTextContent("����");
		groupE1.setTextContent("Dwight");
		// 3):��name,email,address,groupԪ����ΪlinkmanԪ�صĶ���.
		linkmanE1.appendChild(nameE1);
		linkmanE1.appendChild(emailE1);
		linkmanE1.appendChild(addressE1);
		linkmanE1.appendChild(groupE1);
		// 4):��linkmanԪ����Ϊ��Ԫ�صĶ���.
		root.appendChild(linkmanE1);
		// ��:���ڴ��е�Document����ͬ�������̵�XML��.
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		Source xmlSource = new DOMSource(doc);
		Result outputTarget = new StreamResult(f);
		transformer.transform(xmlSource, outputTarget);
	}

	// 4������XML�ļ����ԣ�����/��ȡ��ϵ�˵�id����
	@Test
	public void test4() throws Exception {
		// ��:��ȡDocument�ĵ�����.
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		// ��:��ȡXML�ĸ�Ԫ�ض���.
		Element root = doc.getDocumentElement();
		// ��:��ȡ��������ϵ��
		Element linkmanE2 = (Element) root.getElementsByTagName("linkman").item(2);
		// ��:Ϊ��ǰ��linkman����id����,����ֵΪ9527.
		linkmanE2.setAttribute("id", "9527");
		// ��:���ڴ��е�Document����ͬ�������̵�XML��.
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		Source xmlSource = new DOMSource(doc);
		Result outputTarget = new StreamResult(f);
		transformer.transform(xmlSource, outputTarget);
	}

	// ����:5��ɾ��ָ��Ԫ�ؽڵ㣺ɾ����������ϵ����Ϣ
	@Test
	public void test5() throws Exception {
		// ��:��ȡDocument�ĵ�����.
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		// ��:��ȡXML�ĸ�Ԫ�ض���.
		Element root = doc.getDocumentElement();
		// ��:��ȡ������linkman.
		Element linkmanE1 = (Element) root.getElementsByTagName("linkman").item(2);
		// ��:ɾ������
		//root.removeChild(linkmanE1);
		linkmanE1.getParentNode().removeChild(linkmanE1);
		
		// ��:���ڴ��е�Document����ͬ�������̵�XML��.
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		Source xmlSource = new DOMSource(doc);
		Result outputTarget = new StreamResult(f);
		transformer.transform(xmlSource, outputTarget);
	}
	// ����:6�����ڴ��д���һ��Document����
	@Test
	public void test6() throws Exception {
		File f = new File("/Users/dwight/Desktop/github/JavaStudy/JavaAdvanced/day03-xml/student.xml");
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		doc.setXmlVersion("1.0");
		Element root = doc.createElement("students");
		// ��Ԫ�طŵ��ĵ�������;
		doc.appendChild(root);
		// ����ͬ��
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		Source xmlSource = new DOMSource(doc);
		Result outputTarget = new StreamResult(f);
		transformer.transform(xmlSource, outputTarget);
		
		
	}
}

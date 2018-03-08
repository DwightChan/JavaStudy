package com.dwight._02_junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class JUnit4Test {
	@BeforeClass
	public static void signleInit() {
		System.out.println("signleInit");
	}
	@Before
	public void init() {
		System.out.println("init");
	}
	@Test
	public void testAdd() throws Exception {
		System.out.println("testAdd");
	}
	@Test
	public void testDelete() {
		System.out.println("testDelete");
	}
	@After
	public void destroy() {
		System.out.println("destroy");
	}
	@AfterClass
	public static void signleDestroy () {
		System.out.println("signleDestroy");
	}
}

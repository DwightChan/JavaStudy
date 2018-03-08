package com.dwight._02_junit;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class MathTest {
	IMath math = new MathImpl();
	@Test
	public void testAdd() {
		System.out.println("testAdd");
		int ret = math.add(1, 2);
		Assert.assertEquals("≤ªœ‡µ»",4, ret);
	}

	@Test(expected = ArithmeticException.class)
	public void testDivid() {
		System.out.println("testDivid");
		math.divid(1, 0);
	}
	@Test
	public void testSave() throws Exception {
		Object obj = new Object();
		Assert.assertSame(obj, new Object());
	}
	@Test
	public void testFalse() throws Exception {
		Assert.assertFalse(3 < 2);
	}
	@Test(timeout = 100)
	public void testTimeOut() throws Exception {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 200000; i++) {
			sb.append("asdkfjaskf");
		}
	}
}

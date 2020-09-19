package com.rekent.tools.utils;

import org.junit.Assert;
import org.junit.Test;

import com.rekent.tools.utils.lang.StringUtils;

import junit.framework.TestCase;

public class StringUtilsTest extends TestCase {

	@Test
	public void testStringNotBlank() {
		String testString = "richard.zhang";
		Assert.assertTrue(StringUtils.isNotBlank(testString));
	}

	@Test
	public void testStringBlank() {
		String testString = "richard.zhang";
		Assert.assertTrue(!StringUtils.isBlank(testString));
	}

	@Test
	public void testAnyStringBlank() {
		String testString1 = "richard";
		String testString2 = "";
		Assert.assertTrue(StringUtils.isAnyBank(testString1, testString2));
	}

	@Test
	public void testAllBlank() {
		String testString1 = "";
		String testString2 = "";
		Assert.assertTrue(StringUtils.isAllBlank(testString1, testString2));
	}

	@Test
	public void testEquals() {
		String testString1 = "richard";
		String testString2 = "richard";
		Assert.assertTrue(StringUtils.equals(testString1, testString2));
	}
}

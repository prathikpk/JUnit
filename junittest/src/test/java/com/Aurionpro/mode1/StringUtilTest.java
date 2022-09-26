package com.Aurionpro.mode1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import comm.Aurionpro.model1.StringUtil;

public class StringUtilTest {
	StringUtil util = new StringUtil();
	@Test
	void testTruncateAInFirst2Place() {
		String expected="BCD";
		String actual=util.truncateAInFirstTwoPlace("abcd").toUpperCase();
		assertEquals(expected, actual);
	}
	@Test
	void testTruncateAInFirst2Place1() {
		String expected="BC";
		String actual=util.truncateAInFirstTwoPlace("aabc").toUpperCase();
		assertEquals(expected, actual);
	}
	@Test
	void testTruncateAInFirst2Place2() {
		String expected="BC";
		String actual=util.truncateAInFirstTwoPlace("abc").toUpperCase();
		assertEquals(expected, actual);
	}
	@Test
	void testTruncateAInFirst2Place3() {
		String expected="BCDA";
		String actual=util.truncateAInFirstTwoPlace("bcda").toUpperCase();
		assertEquals(expected, actual);
	}
	@Test
	void testfirstandlasttwocharareequal() {
		Boolean expected=true;
		Boolean actual=util.FirstAndLastTwoCharAreEqual("abccab");
		assertEquals(expected, actual);
	}
	
	
}

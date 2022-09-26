package com.Aurionpro.model;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import comm.Aurionpro.model.MathUtil;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class MathUtilTest {

	MathUtil util;
   
	@Disabled
	@Test
	void test() {
		System.out.println("Hello World");
		fail("this test failed");
	}

	@BeforeAll
	void beforeAll() {
		System.out.println("Printing before all");
	}

	@BeforeEach
	void beforeEach() {
		util=new MathUtil();
		System.out.println("Printing before each");
	}

	@Test
	@DisplayName(value = "Check addition of positive integers")
	void testAddNumber_checkPositiveInteger() {
		int expected = 10;
		int actual = util.addNumber(5, 5);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName(value = "Check addition of positive and Zero")
	void testAddNumber_checkPositiveIntegerAndZero() {
		int expected = 5;
		int actual = util.addNumber(5, 0);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName(value = "Check addition of negative integers")
	void testAddNumber_checkNegativeInteger() {
		int expected = -10;
		int actual = util.addNumber(-5, -5);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName(value = "Check division by positive integers")
	void testDivideNumber_checkDivisionByPositiveNumber() {
		int expected = 10;
		int actual = util.divNumber(100, 10);
		assertEquals(expected, actual);
	}
	@Test
	@DisplayName(value = "Check division by negative integers")
	void testDivideNumber_checkDivisionByNegativeNumber() {
		int expected = -10;
		int actual = util.divNumber(100, -10);
		//assertEquals(expected, actual);
		assertTrue(expected==actual);
	}
//	@Test
//	@DisplayName(value = "Check division by Zero")
//	void testDivideNumber_checkDivisionByZero() {
//		int expected = 10;
//		int actual = util.divNumber(100, 0);
//		assertEquals(expected, actual);
//	}
	@Test
	@DisplayName(value = "Check Arithmetic Exception")
	void testDivideNumber_checkArithmeticException() {
		assertThrows(ArithmeticException.class, (()-> util.divNumber(10, 0)));
	}
	
	@Test
	void testEqualArrays() {
		int a[]= {10,20,30,40};
		int b[]= {10,20,30,40};
		assertArrayEquals(a, b);
	}

}

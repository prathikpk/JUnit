package com.Aurionpro.model2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import comm.Aurionpro.model2.LineItem;
import comm.Aurionpro.model2.Order;
import comm.Aurionpro.model2.Product;

public class productTest {

	Product p1 = new Product(101, "Books", 1000, 5);
	Product p2 = new Product(101, "Games", 2000, 5);

	@Test
	void testCalculatePriceAfterDiscount() {
		double expected = 999.9499999992549;
		double actual = p1.calculatePriceAfterDiscount();
		assertEquals(expected, actual);
	}

	LineItem l1 = new LineItem(101, 2, p1);
	LineItem l2 = new LineItem(101, 2, p2);

	@Test
	void testcalculateLineItemcost() {
		double expected = 1999.8999999985099;
		double actual = l1.calculateLineItemcost();
		assertEquals(expected, actual);
	}

	Order o = new Order(101, "01/02/2022");

	@Test
	void testcalculateOrderPrice() {
		double expected = 5999.79999999702;
		o.addLineItem(l1);
		o.addLineItem(l2);
		double actual = o.calculateOrderPrice();
		assertEquals(expected, actual);
	}

}

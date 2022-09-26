package com.Aurionpro.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCalculator {
	Calculator c;
	CalculatorService service = mock(CalculatorService.class);

	@BeforeEach
	public void init() {
		c = new Calculator(service);
	}

	@Test
	public void testPerform() {
		when(service.add(2, 3)).thenReturn(5);
		assertEquals(10, c.perform(2, 3));
		verify(service).add(2, 3);
	}

}

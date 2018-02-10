package com.techlabs.junit;


import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
	
	@Test
	public void addTwoNumbers()
	{
		Calculator calculator= new Calculator();
		assertEquals(2, calculator.addTwoNumber(1,1));
	}
	
	
}

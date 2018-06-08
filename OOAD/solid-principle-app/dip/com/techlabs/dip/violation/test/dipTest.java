package com.techlabs.dip.violation.test;

import com.techlabs.dip.violation.LogType;
import com.techlabs.dip.violation.TaxCalculator;

public class dipTest {
	public static void main(String args[])
	{
		TaxCalculator taxCalculator=new TaxCalculator(LogType.XML);
		taxCalculator.calculate(10, 0);
	}

}

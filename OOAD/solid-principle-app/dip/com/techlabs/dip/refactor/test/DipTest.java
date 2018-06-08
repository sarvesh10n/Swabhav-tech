package com.techlabs.dip.refactor.test;

import com.techlabs.dip.refactor.CsvLogger;
import com.techlabs.dip.refactor.TaxCalculator;

public class DipTest {
	public static void main(String args[])
	{
		TaxCalculator taxCalculator=new TaxCalculator(new CsvLogger());
		taxCalculator.calculate(10, 0);
	}

}

package com.techlabs.dip.violation;

public class TaxCalculator {
	LogType logtype;

	public TaxCalculator(LogType logtype) {
		this.logtype = logtype;
	}
	//Business logic like calculate is depending on lower layer like logs thats why dip
	public double calculate(int salary,int r)
	{
		int c=0;
		try{
			 c=salary/r;
		}
		catch(Exception e)
		{
			if(logtype==LogType.XML)
				new Xml().log(e.getMessage());
			else if(logtype==LogType.CSV)
				new Csv().log(e.getMessage());
		}
		return c;
	}
}

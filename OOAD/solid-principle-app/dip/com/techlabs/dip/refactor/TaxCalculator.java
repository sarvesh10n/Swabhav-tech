package com.techlabs.dip.refactor;

public class TaxCalculator {
	ILog logtype;

	public TaxCalculator(ILog logtype) {
		this.logtype = logtype;
	}

	// Business logic like calculate is depending on lower layer like logs thats
	// why dip
	public double calculate(int salary, int r) {
		int c = 0;
		try {
			c = salary / r;
		} catch (Exception e) {
			logtype.log(e.getMessage());
			throw e;
		}

		return c;
	}
}

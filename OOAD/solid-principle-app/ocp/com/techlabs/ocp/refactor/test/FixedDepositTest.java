package com.techlabs.ocp.refactor.test;

import com.techlabs.ocp.refactor.FixedDeposit;
import com.techlabs.ocp.refactor.Holi;
import com.techlabs.ocp.refactor.NewYear;
import com.techlabs.ocp.refactor.Normal;

public class FixedDepositTest {

	public static void main(String args[]) {
		FixedDeposit fixedDeposit = new FixedDeposit(1, "Sarvesh", 50000, 2,
				new Normal());
		System.out.println("AccNo\tName\tAmount\tYears\tInterest");
		System.out.println(fixedDeposit.getAccNo() + "\t"
				+ fixedDeposit.getName() + "\t" + fixedDeposit.getPrinciple()
				+ "\t" + fixedDeposit.getYears() + "\t"
				+ fixedDeposit.calculateTotalInterest());
	}
}

package com.techlabs.ocp.violation.test;

import com.techlabs.ocp.violation.FestivalType;
import com.techlabs.ocp.violation.FixedDeposit;

public class FixedDepositTest {

	public static void main(String args[]) {
		FixedDeposit fixedDeposit = new FixedDeposit(1, "Sarvesh", 50000, 2,
				FestivalType.HOLI);
		System.out.println("AccNo\tName\tAmount\tYears\tInterestType");
		System.out.println(fixedDeposit.getAccNo() + "\t"
				+ fixedDeposit.getName() + "\t" + fixedDeposit.getPrinciple()
				+ "\t" + fixedDeposit.getYears() + "\t"
				+ fixedDeposit.calculateTotalInterest());
	}
}

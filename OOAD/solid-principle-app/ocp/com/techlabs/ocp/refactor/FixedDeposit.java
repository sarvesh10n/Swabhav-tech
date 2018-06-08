package com.techlabs.ocp.refactor;

public class FixedDeposit {

	private int accNo;
	private String name;
	private double principle;
	private int years;
	private IFestivalType festival;

	public FixedDeposit(int accNo, String name, double principle, int years,
			IFestivalType festival) {
		this.accNo = accNo;
		this.name = name;
		this.principle = principle;
		this.years = years;
		this.festival = festival;
	}

	public double calculateTotalInterest() {
		return principle * years * festival.getRate();
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrinciple() {
		return principle;
	}

	public void setPrinciple(double principle) {
		this.principle = principle;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}


}

package com.techlabs.ocp.violation;

public class FixedDeposit {

	private int accNo;
	private String name;
	private double principle;
	private int years;
	private FestivalType festival;

	public FixedDeposit(int accNo, String name, double principle, int years,
			FestivalType festival) {
		this.accNo = accNo;
		this.name = name;
		this.principle = principle;
		this.years = years;
		this.festival = festival;
	}

	public double calculateTotalInterest() {
		double rate=0.07;
		if (festival == FestivalType.NEW_YEAR) {
			rate = 0.08;
		} else if (festival == FestivalType.HOLI) {
			rate = 0.085;
		} else if (festival == FestivalType.NORMAL) {
			rate = 0.07;
		}
		return principle * years * rate;
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

	public FestivalType getFestival() {
		return festival;
	}

	public void setFestival(FestivalType festival) {
		this.festival = festival;
	}

}

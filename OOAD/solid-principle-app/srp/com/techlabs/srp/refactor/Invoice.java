package com.techlabs.srp.refactor;

public class Invoice {

	private int no;
	private String name;
	private double cost;
	private double percentageDiscount;
	private final float GST = 0.05f;

	public Invoice(int no, String name, double cost, double percentageDiscount) {
		this.no = no;
		this.name = name;
		this.cost = cost;
		this.percentageDiscount = percentageDiscount;
	}

	private double calculateDiscount() {
		return cost * (percentageDiscount / 100);
	}

	private double calculateTax() {
		return cost * (GST / 100);
	}

	public double totalCost() {
		return cost - calculateDiscount() + calculateTax();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}

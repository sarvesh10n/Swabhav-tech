package com.techlabs.employee;

public class Manager extends Employee {

	private final static double  HRA_PERCENTAGE=50;
	private final static double TA_PERCENTAGE=40;
	private double hra;
	private double ta;
	
	public Manager(String name, double basicSalary) {
		super(name, basicSalary);
	}
	
	public double calculateNetSalary()
	{
		getHra();
		getTa();
		return (basicSalary+hra+ta);
	}

	private void getTa()
	{
		ta=(basicSalary*TA_PERCENTAGE)/100;
	}
	private void getHra() {
		hra=(basicSalary*HRA_PERCENTAGE)/100;
	}
}

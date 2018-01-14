package com.techlabs.employee;

public class Developer extends Employee{
	
	private double perks;
	private double perksPercentage=30;

	public Developer(String name,double basicSalary)
	{
		super(name,basicSalary);
	}
	
	public double calculateNetSalary()
	{
		getPerk();
		
		return (perks+basicSalary);
	}

	private void getPerk() {
		perks=(basicSalary*perksPercentage)/100;
	}
}

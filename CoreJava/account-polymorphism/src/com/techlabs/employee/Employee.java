package com.techlabs.employee;

public abstract class Employee {

	protected static int eNoCounter;
	static {
		eNoCounter = 0;
	}

	protected String name;
	protected final int eNo;
	protected double basicSalary;

	public String getName() {
		return name;
	}

	public int getEno() {
		return eNo;
	}

	public Employee(String name, double basicSalary) {
		eNoCounter=eNoCounter+1;
		this.eNo = eNoCounter;
		this.name = name;
		this.basicSalary = basicSalary;
	}

	public abstract double calculateNetSalary();

}

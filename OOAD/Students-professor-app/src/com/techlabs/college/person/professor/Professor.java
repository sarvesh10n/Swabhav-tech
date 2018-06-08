package com.techlabs.college.person.professor;

import java.util.Date;

import com.techlabs.college.person.ISalariedEmployee;
import com.techlabs.college.person.Person;

public class Professor extends Person implements ISalariedEmployee{
	
	
	
	public Professor(String name, String address, Date dob, double basic_salary) {
		super(name, address, dob);
		this.basic_salary = basic_salary;
	}

	private double  basic_salary;

	@Override
	public double calculateSalary() {
		double da_cost = basic_salary*da/100;
		double hra_cost = basic_salary*hra/100;
		double pf_cost = basic_salary*pf/100;
		double income_tax = basic_salary*10/100;
		double gross_salary = basic_salary+da_cost+hra_cost;
		double deduction = pf_cost+income_tax;
		double net_salary = gross_salary-deduction;
		return net_salary;
	}

	public double getBasicSalary() {
		return basic_salary;
	}

	public void setBasic_salary(double basic_salary) {
		this.basic_salary = basic_salary;
	}
	
}

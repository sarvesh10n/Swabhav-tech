package com.techlabs.employee.test;

import com.techlabs.employee.*;

public class EmployeeTest {

	public static void main(String args[]) {
		Manager manager = new Manager("sarvesh", 5000);
		Developer developer = new Developer("santosh", 4000);

		calculateSalary(manager);
		calculateSalary(developer);

	}

	public static void calculateSalary(Employee emp) {
		System.out.println("----Employee details----");
		System.out.println("Employee number is: "+emp.getEno());
		System.out.println("Employee name is: "+emp.getName());
		System.out.println("Employee salary is: "+emp.calculateNetSalary());
		System.out.println();

	}

}

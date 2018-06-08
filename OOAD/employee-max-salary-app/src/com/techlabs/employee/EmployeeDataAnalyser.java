package com.techlabs.employee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.TreeSet;

import com.techlabs.parser.IParser;

public class EmployeeDataAnalyser {
	IParser parser;

	TreeSet<Employee> empList;

	public EmployeeDataAnalyser(IParser parser) {
		this.parser = parser;
	}

	public Employee maxAnnualSalary() throws FileNotFoundException, IOException {
		empList = parser.parseFile();
		double maxSalary = 0;
		int empId = 0;
		for (Employee employee : empList) {
			double empSalary = employee.calcAnuualSalary();
			if (empSalary > maxSalary) {
				maxSalary = empSalary;
				empId = employee.geteNo();
			}
		}

		for (Employee employee : empList) {
			if (employee.geteNo() == empId)
				return employee;
		}
		return empList.first();
	}

	
	public void getEmployeeAccToDept() {
		TreeSet<Employee> unique = new TreeSet<Employee>(new DeptComparator());
		unique.addAll(empList);
		for (Employee key : unique) {
			System.out.println(key.getDeptNo() + ": "
					+ Collections.frequency(empList, key.getDeptNo()));
		}
	}
	
	public void getEmployeeAccToRole() {
		TreeSet<Employee> unique = new TreeSet<Employee>(new RoleComparator());
		unique.addAll(empList);
		for (Employee key : unique) {
			System.out.println(key.getRole() + ": "
					+ Collections.frequency(empList, key.getRole()));
		}
	}

}

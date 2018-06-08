package com.techlabs.employee.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.techlabs.employee.Employee;
import com.techlabs.employee.EmployeeDataAnalyser;
import com.techlabs.loader.TextFileLoader;
import com.techlabs.parser.CsvParser;

public class EmployeeTest {

	public static void main(String args[]) throws FileNotFoundException,
			IOException {
		EmployeeDataAnalyser employeeDataAnalyser = new EmployeeDataAnalyser(
				new CsvParser(new TextFileLoader()));
		Employee employee = employeeDataAnalyser.maxAnnualSalary();
		System.out.println("Employee with maximum salary is:");
		System.out.println("Employee id: " + employee.geteNo());
		System.out.println("Employee Name: " + employee.geteName());
//		employeeDataAnalyser.getEmployeeAccToDept();
//		employeeDataAnalyser.getEmployeeAccToRole();

	}
}

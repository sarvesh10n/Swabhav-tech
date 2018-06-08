package com.techlabs.unitTesting;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.TreeSet;

import org.junit.Test;

import static org.junit.Assert.*;

import com.techlabs.employee.Employee;
import com.techlabs.employee.EmployeeDataAnalyser;
import com.techlabs.loader.TextFileLoader;
import com.techlabs.parser.CsvParser;

public class unitTest {

	@Test
	public void checkIfCalculateSalaryWorking() {

	}

	@Test
	public void checkIfLoadingIsWorking() throws IOException {
		TextFileLoader textFileLoader = new TextFileLoader();
		String reader = textFileLoader.loadFile();
		if(reader.isEmpty())
			reader="false";
		else 
			reader="true";
		assertEquals(reader, "true");
	}

	@Test
	public void checkIfParsingIsWorking() throws IOException {
		CsvParser csvParser = new CsvParser(new TextFileLoader());
		csvParser.parseFile();
		TreeSet<Employee> list = csvParser.getEmployeeList();
		for (Employee emp : list) {
			System.out.println(emp.geteName());
		}

	}
	@Test
	public void getMaximumAnnualSalaryEmployee() throws FileNotFoundException, IOException
	{
		EmployeeDataAnalyser employeeDataAnalyser=new EmployeeDataAnalyser(new CsvParser(new TextFileLoader()));
		Employee emp=employeeDataAnalyser.maxAnnualSalary();
		System.out.println(emp.geteName());
	}
	
}

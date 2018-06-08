package com.techlabs.parser;

import java.io.IOException;
import java.util.TreeSet;

import com.techlabs.employee.Employee;
import com.techlabs.loader.ILoadable;

public class CsvParser implements IParser {

	TreeSet<Employee> employeeList = new TreeSet<Employee>();

	private ILoadable loadFile;

	public CsvParser(ILoadable loadFile) {
		this.loadFile = loadFile;
	}

	@Override
	public TreeSet<Employee> parseFile() throws IOException {
		String data = loadFile.loadFile();
		String lines[] = data.split("\n");
		for (String line : lines)
			addEmployee(line);
		return employeeList;
	}

	private void addEmployee(String line) {

		String[] employeeDetails = line.split(",");
		Employee employee = new Employee();
		employee.seteNo(Integer.parseInt(employeeDetails[0]));
		
		employee.seteName(employeeDetails[1].replaceAll("\'", ""));
		
		employee.setRole(employeeDetails[2].replaceAll("\'", ""));
		
		if (employeeDetails[3].equals("NULL"))
			employeeDetails[3] = "-999";
		employee.setmId(Integer.parseInt(employeeDetails[3]));
		
		employee.setDoj(employeeDetails[4].replaceAll("\'", ""));
		
		employee.setSalary(Double.parseDouble(employeeDetails[5]));
		
		if (employeeDetails[6].equals("NULL"))
			employeeDetails[6] = "0";
		employee.setCommision(Double.parseDouble(employeeDetails[6]));
		
		employee.setDeptNo(Integer.parseInt(employeeDetails[7]));

		employeeList.add(employee);

	}

	public TreeSet<Employee> getEmployeeList() {
		return employeeList;
	}

}

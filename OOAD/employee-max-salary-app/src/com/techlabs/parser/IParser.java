package com.techlabs.parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.TreeSet;

import com.techlabs.employee.Employee;

public interface IParser {

	public TreeSet<Employee> parseFile() throws FileNotFoundException, IOException;
}

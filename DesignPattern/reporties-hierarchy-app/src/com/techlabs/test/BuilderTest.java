package com.techlabs.test;

import java.io.IOException;
import java.util.TreeSet;

import com.techlabs.builder.OrganisationFileBuilder;
import com.techlabs.employee.dto.Employee;
import com.techlabs.loader.TextFileLoader;
import com.techlabs.parser.CsvParser;
import com.techlabs.parser.IParser;

public class BuilderTest {

	static TreeSet<Employee> empList;
	
	public static void main(String args[]) throws IOException
	{
		OrganisationFileBuilder hierarchyBuilder=new OrganisationFileBuilder(new CsvParser(new TextFileLoader()));
		hierarchyBuilder.build();
	}
}

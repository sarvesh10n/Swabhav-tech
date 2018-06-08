package com.techlabs.builder;

import com.techlabs.employee.dto.*;
import com.techlabs.parser.IParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class OrganisationFileBuilder {

	public OrganisationFileBuilder(IParser parser) {
		this.parser = parser;
	}

	private TreeSet<Employee> empList;
	private Map<Integer, Employee> multiMap = new HashMap<Integer, Employee>();
	private Employee ceo;
	private IParser parser;

	public void build() throws FileNotFoundException, IOException {
		empList = parser.parseFile();
		for (Employee emp : empList) {
			if(!multiMap.containsKey(emp.geteNo()))
				multiMap.put(emp.geteNo(),emp);
		}
		for(Employee emp:empList){
			if(multiMap.containsKey(emp.getmId()))
			{
				Employee managerEmployee=multiMap.get(emp.getmId());
				System.out.println(managerEmployee);
				managerEmployee.addReporties(emp);
				multiMap.put(emp.getmId(),emp);
			}
			else
				ceo=emp;
		}
		System.out.println(Collections.singletonList(multiMap));
		
	}

}

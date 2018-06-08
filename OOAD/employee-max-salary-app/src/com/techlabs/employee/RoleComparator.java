package com.techlabs.employee;

import java.util.Comparator;

public class RoleComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {

		if(e1.equals(e2))
			return 1;
		else
			return -1;
	}

}

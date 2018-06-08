package com.techlabs.employee;

import java.util.Comparator;

public class DeptComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		
		if(e1.getDeptNo() == e2.getDeptNo()){
            return 0;
        } if(e1.getDeptNo() < e2.getDeptNo()){
            return 1;
        } else {
            return -1;
        }
	}
	

}

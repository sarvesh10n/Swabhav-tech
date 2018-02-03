package com.techlabs.crudable.test;

import com.techlabs.crudable.*;

public class TestCrudable {

	public static void main(String args[]) {
		CustomerDB customerDB = new CustomerDB();
		DeptDB deptDB = new DeptDB();
		EmpDB empDB=new EmpDB();

		dbOperations(customerDB);
		dbOperations(deptDB);
		dbOperations(empDB);
	}

	public static void dbOperations(ICrudable crud) {
		System.out.println();
		crud.create();
		crud.read();
		crud.update();
		crud.delete();
	}
}

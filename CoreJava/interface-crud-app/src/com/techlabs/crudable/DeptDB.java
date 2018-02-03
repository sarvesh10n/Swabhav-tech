package com.techlabs.crudable;

public class DeptDB implements ICrudable{
	
	public void create() {
		System.out.println("department create");
	}

	public void read() {
		System.out.println("department read");
	}

	public void update() {
		System.out.println("department update");
	}

	public void delete() {
		System.out.println("department delete");
	}

}

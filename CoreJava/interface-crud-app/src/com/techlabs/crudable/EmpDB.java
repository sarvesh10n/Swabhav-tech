package com.techlabs.crudable;

public class EmpDB implements ICrudable{

	public void create() {
		System.out.println("employee create");
	}

	public void read() {
		System.out.println("employee read");
	}

	public void update() {
		System.out.println("employee update");
	}

	public void delete() {
		System.out.println("employee delete");
	}
}

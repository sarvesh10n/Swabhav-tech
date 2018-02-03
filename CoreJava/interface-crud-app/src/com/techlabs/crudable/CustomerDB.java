package com.techlabs.crudable;

public class CustomerDB implements ICrudable {

	public void create() {
		System.out.println("customer create");
	}

	public void read() {
		System.out.println("customer read");
	}

	public void update() {
		System.out.println("customer update");
	}

	public void delete() {
		System.out.println("customer delete");
	}

}

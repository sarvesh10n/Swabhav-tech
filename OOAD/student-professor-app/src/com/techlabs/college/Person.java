package com.techlabs.college;

import java.util.UUID;

import javax.xml.crypto.Data;

public abstract class Person {

	private UUID id;
	private String address;
	private Data dob;
	
	public Person(){
		id=UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Data getDob() {
		return dob;
	}

	public void setDob(Data dob) {
		this.dob = dob;
	}

}

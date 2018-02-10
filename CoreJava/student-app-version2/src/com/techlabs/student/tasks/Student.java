package com.techlabs.student.tasks;

import java.io.Serializable;
import java.util.UUID;

public class Student implements Serializable {

	private String firstName;
	private String lastName;
	private String address;
	private UUID rollNo;

	public Student() {
		rollNo = UUID.randomUUID();
	}

	public UUID getRollNo() {
		return rollNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

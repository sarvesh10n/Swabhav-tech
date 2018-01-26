package com.techlabs.student;

import com.techlabs.student.functions.*;
import java.io.Serializable;

public class Student implements Serializable {

	static int rollCount;
	private String firstName;
	private String lastName;
	private String address;
	private int rollNo;

	static {
		rollCount = FetchData.fetchRollNo();
	}

	public Student() {
		rollCount++;
		rollNo = rollCount;
		System.out.println("Roll no is" + rollNo);
	}

	public int getRollNo() {
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

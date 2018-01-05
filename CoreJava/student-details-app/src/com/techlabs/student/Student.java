package com.techlabs.student;

import java.io.Serializable;

public class Student implements Serializable{

	private String firstName;
	private String lastName;
	private String address;

	public void displayStudentDetails() {
		System.out.println("Name of student is " + firstName + " " + lastName);
		System.out.println("Address of student is " + address);
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName=firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName=lastName;
	}
	
	public void setAddress(String address)
	{
		this.address=address;
	}
}

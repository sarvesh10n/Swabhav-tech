package com.techlabs.student;

public class Student {

	private String firstName;
	private String lastName;
	private String address;

	public Student(String firstName, String lastName, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	@Override
	public int hashCode() {
		return firstName.hashCode();
	}
	
	@Override
	public boolean equals(Object student)
	{
		Student s=(Student)student;
		return((getFirstName().equals(s.getFirstName())&&(getLastName().equals(s.getLastName()))&&getAddress().equals(s.getAddress())));
				
	}

	@Override
	public String toString() {
		return " Name is: " + firstName + " " + lastName + " Address is: "
				+ address;
	}

	public void displayStudentDetails() {
		System.out.println("Name of student is " + firstName + " " + lastName);
		System.out.println("Address of student is " + address);
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

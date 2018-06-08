package com.techlabs.college.person;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.UUID;
import java.util.Date;

public abstract class Person {

	private UUID id;
	private String name;

	public Person(String name, String address, Date dob) {
		this.name = name;
		this.address = address;
		this.dob = dob;
	}

	private String address;
	private Date dob;

	public Person() {
		id = UUID.randomUUID();
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getAge() {
		return Period.between(
				dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				LocalDate.now()).getYears();
	}

}

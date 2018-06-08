package com.techlabs.college.person.student;

import java.util.Date;

import com.techlabs.college.person.Person;


public class Student extends Person{

	BRANCH branch;
	
	public Student(String name,String address,Date dob,BRANCH branch)
	{
		super(name,address,dob);
		this.branch=branch;
	}

	public BRANCH getBranch() {
		return branch;
	}

	public void setBranch(BRANCH branch) {
		this.branch = branch;
	}
}

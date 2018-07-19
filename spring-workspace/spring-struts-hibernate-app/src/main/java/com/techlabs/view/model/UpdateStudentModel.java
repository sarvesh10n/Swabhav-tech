package com.techlabs.view.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.techlabs.entity.Student;
import com.techlabs.service.StudentService;

public class UpdateStudentModel {
	private Student student;
	private int rollNo;
	
	@Autowired
	private StudentService service;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public StudentService getService() {
		return service;
	}

	public void setService(StudentService service) {
		this.service = service;
	}
	
	
}

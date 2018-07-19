package com.techlabs.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.entity.Student;
import com.techlabs.service.StudentService;

public class UpdateStudentAction implements Action{

	private Student student;
	private int rollNo;
	@Autowired
	StudentService updateService;
	
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

	public String updateStudent(){
		updateService.updateStudent(rollNo,student);
		return this.SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		student=updateService.getStudentForUpdate(rollNo);
		return this.SUCCESS;
	}

}

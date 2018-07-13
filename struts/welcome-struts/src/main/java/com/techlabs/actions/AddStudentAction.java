package com.techlabs.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.model.Student;
import com.techlabs.model.StudentService;

public class AddStudentAction extends ActionSupport {

	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String addStudent() {
		new StudentService().addStudentList(student);
		return this.SUCCESS;
	}

	@Override
	public void validate() {
		if (student.getName().equals("")) {
			addFieldError("student.name", "Enter the name");
		}

		if (student.getEmail().length() == 0) {
			addFieldError("student.email", "Email is required.");
		}
		if (student.getPhoneNo().toString().length() == 0) {
			addFieldError("student.phoneNo", "Phone no is required");
		}
	}

	@Override
	public String execute() throws Exception {
		return this.SUCCESS;
	}

}

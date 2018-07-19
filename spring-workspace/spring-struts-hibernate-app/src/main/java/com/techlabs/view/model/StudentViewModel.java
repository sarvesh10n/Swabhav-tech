package com.techlabs.view.model;

import java.util.ArrayList;


import com.techlabs.entity.Student;

public class StudentViewModel {

	private ArrayList<Student> studentList = new ArrayList<>();

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

}

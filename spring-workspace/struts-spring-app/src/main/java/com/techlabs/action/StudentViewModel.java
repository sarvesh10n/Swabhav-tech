package com.techlabs.action;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.techlabs.model.Student;

public class StudentViewModel {

	private ArrayList<Student> studentList=new ArrayList<>();

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
}

package com.techlabs.model;

import java.util.ArrayList;

public class StudentService {
	
	private static ArrayList<Student> studentList=new ArrayList<>();
	
	public StudentService(){
	}

	public void addStudentList(Student student){
		studentList.add(student);
	}
	
	public ArrayList<Student> getStudentList(){
		return studentList;
	}
}

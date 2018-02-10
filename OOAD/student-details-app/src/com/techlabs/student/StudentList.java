package com.techlabs.student;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentList implements Serializable {

	public static ArrayList<Student> studentList = new ArrayList<Student>();

	public void studentAdd(Student student) {
		studentList.add(student);
	}

}

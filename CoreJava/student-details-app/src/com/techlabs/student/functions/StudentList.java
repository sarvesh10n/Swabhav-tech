package com.techlabs.student.functions;

import java.io.Serializable;
import java.util.ArrayList;

import com.techlabs.student.Student;

public class StudentList implements Serializable{

	public static ArrayList<Student> studentList = new ArrayList<Student>();

	public static int getCountOfStudent() {
		return studentList.size();
	}

}

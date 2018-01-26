package com.techlabs.student.functions;

import com.techlabs.student.Student;

public class DisplayList {

	public void displayStudentList() {
		int i = 1;
		System.out.println("----Student details-----");
		for (Student student : StudentList.studentList) {
			System.out.println(i++ + ")");
			System.out.println("Roll No of student is "+student.getRollNo());
			System.out.println("Name of student is " + student.getFirstName() + " " + student.getLastName());
			System.out.println("Address of student is " + student.getAddress());
			System.out.println();
		}
	}
}

package com.techlabs.student.functions;

import com.techlabs.student.Student;

public class DisplayList {

	public void displayStudentList() {
		int i = 1;
		System.out.println("----Student details-----");
		for (Student student : StudentList.studentList) {
			System.out.println(i++ + ")");
			student.displayStudentDetails();
			System.out.println();
		}
	}
}

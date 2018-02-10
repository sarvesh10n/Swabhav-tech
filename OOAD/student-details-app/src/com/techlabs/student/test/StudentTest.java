package com.techlabs.student.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentTest {

	private static final int GENERATE_RESUME = 4;
	private static final int COUNT_STUDENT = 3;
	private static final int ADD_STUDENT = 2;
	private static final int DISPLAY_STUDENT_DETAILS = 1;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int choice;
		
		boolean flag = true;
		while (flag) {
			System.out.println("1:Display student details");
			System.out.println("2:Add student");
			System.out.println("3:Count number of student");
			System.out.println("4:Build student resumes");
			System.out.println("5:Exit");
			choice = Integer.parseInt(br.readLine());
			if (choice == 5)
				flag = false;
			else
				performAction(choice);
		}
	}

	private static void performAction(int choice) {
		if (choice == DISPLAY_STUDENT_DETAILS) {
			new DisplayList().displayStudentList();
		}

		else if (choice == ADD_STUDENT) {
			new AddStudent().addStudent();
		}
		else if (choice == COUNT_STUDENT) {
			System.out.println(StudentList.getCountOfStudent());
		}
		else if (choice == GENERATE_RESUME) {
			new GenerateResumes().generateResumes();
		}
	}
}

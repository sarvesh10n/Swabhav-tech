package com.techlabs.student.test;

import com.techlabs.resume.builder.GenerateResumes;
import com.techlabs.student.functions.*;

import java.io.*;

import com.techlabs.student.functions.AddStudent;
import com.techlabs.student.functions.DisplayList;

public class StudentTest {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int choice;
		// For initializing ArrayList with previous data
		FetchData.fetchData();
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
		if (choice == 1) {
			new DisplayList().displayStudentList();
		}

		else if (choice == 2) {
			new AddStudent().addStudent();
		}
		else if (choice == 3) {
			System.out.println(StudentList.getCountOfStudent());
		}
		else if (choice == 4) {
			new GenerateResumes().generateResumes();
		}
	}
}

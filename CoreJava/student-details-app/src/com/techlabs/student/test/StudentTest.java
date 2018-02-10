package com.techlabs.student.test;

import com.techlabs.resume.builder.GenerateResumes;
import com.techlabs.student.Student;
import com.techlabs.student.functions.*;

import java.io.*;

import com.techlabs.student.functions.AddStudent;
import com.techlabs.student.functions.DisplayList;
import com.techlabs.student.functions.FetchData;

public class StudentTest {

	private static final int GENERATE_RESUME = 4;
	private static final int COUNT_STUDENT = 3;
	private static final int ADD_STUDENT = 2;
	private static final int DISPLAY_STUDENT_DETAILS = 1;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		FetchData.fetchData();
		int choice;
		StudentList studentList = new StudentList();
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
			else {
				if (choice == DISPLAY_STUDENT_DETAILS) {
					displayStudentList();
				}

				else if (choice == ADD_STUDENT) {
					try {
						Student student = new Student();
						System.out.println("Enter first name");
						student.setFirstName(br.readLine());
						System.out.println("Enter last name");
						student.setLastName(br.readLine());
						System.out.println("Enter Address");
						student.setAddress(br.readLine());
						studentList.addStudent(student);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (choice == COUNT_STUDENT) {
					System.out.println(StudentList.getCountOfStudent());
				} else if (choice == GENERATE_RESUME) {
					new GenerateResumes().generateResumes();
				}
			}

		}

	}
	

}

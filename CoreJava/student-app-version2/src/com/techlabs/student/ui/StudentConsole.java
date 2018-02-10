package com.techlabs.student.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.techlabs.generate.resume.GenerateResumes;
import com.techlabs.student.tasks.Student;
import com.techlabs.student.tasks.StudentDataStore;


public class StudentConsole {

	private static final int GENERATE_RESUME = 4;
	private static final int COUNT_STUDENT = 3;
	private static final int ADD_STUDENT = 2;
	private static final int DISPLAY_STUDENT_DETAILS = 1;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private boolean wait=true;
	private int choice;

	public void startApp()
	{
		StudentDataStore studentDataStore=new StudentDataStore();
		while(wait)
		{
			System.out.println("1:Display student details");
			System.out.println("2:Add student");
			System.out.println("3:Count number of student");
			System.out.println("4:Build student resumes");
			System.out.println("5:Exit");
			try {
				choice = Integer.parseInt(br.readLine());
			} catch (Exception e1) {
			}
			if (choice == 5)
			{
				studentDataStore.saveData();
				wait = false;
			}
			else {
					if (choice == DISPLAY_STUDENT_DETAILS) {
						displayStudentList(studentDataStore);
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
							studentDataStore.addStudent(student);
							} catch (IOException e) {
								e.printStackTrace();
							}
					} else if (choice == COUNT_STUDENT) {
							System.out.println(studentDataStore.getStudentCount());
					} else if (choice == GENERATE_RESUME) {
						new GenerateResumes().generateResumes();
				}
			}
		}	
	}
	public void displayStudentList(StudentDataStore studentDataStore) {
		int i = 1;
		System.out.println("----Student details-----");
		for (Student student : studentDataStore.getList()) {
			System.out.println(i++ + ")");
			System.out.println("Roll No of student is "+student.getRollNo());
			System.out.println("Name of student is " + student.getFirstName() + " " + student.getLastName());
			System.out.println("Address of student is " + student.getAddress());
			System.out.println();
		}
	
}
}

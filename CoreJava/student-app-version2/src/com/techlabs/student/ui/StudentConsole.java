package com.techlabs.student.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.techlabs.generate.resume.GenerateResumes;
import com.techlabs.student.tasks.Student;
import com.techlabs.student.tasks.StudentDataStore;


public class StudentConsole {

	private static final int REMOVE_STUDENT = 6;
	private static final int SEARCH_KEY = 5;
	private static final int GENERATE_RESUME = 4;
	private static final int COUNT_STUDENT = 3;
	private static final int ADD_STUDENT = 2;
	private static final int DISPLAY_STUDENT_DETAILS = 1;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private boolean wait=true;
	private int choice;

	public void startApp() throws IOException
	{
		StudentDataStore studentDataStore=new StudentDataStore();
		while(wait)
		{
			System.out.println("------------------Menu--------------------");
			System.out.println("1:Display student details");
			System.out.println("2:Add student");
			System.out.println("3:Count number of student");
			System.out.println("4:Build student resumes");
			System.out.println("5:Search");
			System.out.println("6:Remove student");
			System.out.println("7:Exit");
			try {
				choice = Integer.parseInt(br.readLine());
			} catch (Exception e1) {
			}
			if (choice == 7)
			{
				studentDataStore.saveData();
				wait = false;
			}
			else {
					if (choice == DISPLAY_STUDENT_DETAILS) {
						displayStudentList(studentDataStore.getList());
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
					else if(choice==SEARCH_KEY){
						System.out.println("Enter the search string");
						String key= br.readLine();
						displayStudentList(studentDataStore.search(key));
					}
					else if(choice==REMOVE_STUDENT)
					{
						System.out.println("Enter the Roll no for deletion");
						String rollNo=br.readLine();
						studentDataStore.removeStudent(rollNo);
					}
			}
		}	
	}
	public void displayStudentList(Iterable<Student> student_list) {
		int i = 1;
		System.out.println("----------Student details--------------");
		for (Student student : student_list) {
			System.out.println(i++ + ")");
			System.out.println("Roll No of student is "+student.getRollNo());
			System.out.println("Name of student is " + student.getFirstName() + " " + student.getLastName());
			System.out.println("Address of student is " + student.getAddress());
			System.out.println();
		}
	
}
}

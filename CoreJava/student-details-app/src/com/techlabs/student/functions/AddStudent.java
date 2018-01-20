package com.techlabs.student.functions;

import java.io.*;

import com.techlabs.student.Student;

public class AddStudent {

	public void addStudent(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Student student = new Student();
			System.out.println("Enter first name");
			student.setFirstName(br.readLine());
			System.out.println("Enter last name");
			student.setLastName(br.readLine());
			System.out.println("Enter Address");
			student.setAddress(br.readLine());
			addStudentToList(student);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void addStudentToList(Student student) {
		StudentList.studentList.add(student);
		saveData();
	}

	private static void saveData() {
		try {
			FileOutputStream fs = new FileOutputStream("Data/student_data.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(StudentList.studentList);
			os.close();
		}

		catch (IOException e) {
			System.out.println("file not found");
		}
	}

}

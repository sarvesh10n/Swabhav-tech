package com.techlabs.student.test;

import java.io.*;
import java.util.ArrayList;

import com.techlabs.student.Student;

public class StudentTest implements Serializable {

	static ArrayList<Student> studentList = new ArrayList<Student>();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int choice;
		// For initializing ArrayList with previous data
		fetchData();
		boolean flag = true;
		while (flag) {
			System.out.println("1:Display student details");
			System.out.println("2:Add student");
			System.out.println("3:Count number of student");
			System.out.println("4:Exit");
			choice = Integer.parseInt(br.readLine());
			if (choice == 4)
				flag = false;
			else
				performAction(choice);
		}
	}

	private static void performAction(int choice) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		if (choice == 1) {
			int i = 1;
			for (Student student : studentList) {
				System.out.println(i++ + ")");
				student.displayStudentDetails();
				System.out.println();
			}
		}

		else if (choice == 2) {
			Student student = new Student();
			System.out.println("Enter first name");
			student.setFirstName(br.readLine());
			System.out.println("Enter last name");
			student.setLastName(br.readLine());
			System.out.println("Enter Address");
			student.setAddress(br.readLine());
			addStudentToList(student);
		}

		else if (choice == 3)
			System.out.println(studentList.size());

	}

	private static void addStudentToList(Student student) {
		studentList.add(student);
		saveData();
	}

	private static void saveData() {
		try {
			FileOutputStream fs = new FileOutputStream("Data/student_data.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(studentList);
		}

		catch (IOException e) {
			System.out.println("file not found");
		}
	}

	private static void fetchData() {
		try {
			FileInputStream is = new FileInputStream("Data/student_data.ser");
			ObjectInputStream ois = new ObjectInputStream(is);
			studentList = (ArrayList<Student>) ois.readObject();
		} catch (Exception e) {
		}
	}
}

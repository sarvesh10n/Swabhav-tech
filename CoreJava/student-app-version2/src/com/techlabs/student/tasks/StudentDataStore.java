package com.techlabs.student.tasks;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StudentDataStore {
	public ArrayList<Student> studentList = new ArrayList<Student>();

	public StudentDataStore() {
		fetchData();
	}

	public void addStudent(Student student) {
		studentList.add(student);
	}

	public ArrayList<Student> getList() {
		return studentList;
	}

	public int getStudentCount() {
		return studentList.size();
	}

	public void fetchData() {
		try {
			FileInputStream is = new FileInputStream("Data/student_data.ser");
			ObjectInputStream ois = new ObjectInputStream(is);
			studentList = (ArrayList<Student>) ois.readObject();
			ois.close();
		} catch (Exception e) {
		}
	}

	public void saveData() {
		try {
			FileOutputStream fs = new FileOutputStream("Data/student_data.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(studentList);
			os.close();

		} catch (IOException e) {
			System.out.println("file not found");
		}
	}

}

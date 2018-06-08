package com.techlabs.student.tasks;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.UUID;

import com.techlabs.custom.exceptions.StudentNotFoundException;

public class StudentDataStore {
	public ArrayList<Student> studentList = new ArrayList<Student>();

	public StudentDataStore() {
		fetchData();
	}

	public void addStudent(Student student) {
		studentList.add(student);
	}

	public Iterable<Student> getList() {
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
			System.out.println("File not found");
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

	public Iterable<Student> search(String key) {
		ArrayList<Student> search_result = new ArrayList<Student>();
		for (Student stud : studentList) {
			if (stud.getFirstName().toLowerCase().startsWith(key.toLowerCase())) {
				search_result.add(stud);
			}
		}
		if(search_result.isEmpty())
			throw new StudentNotFoundException("No such student found");
		else	
			return search_result;
	}

	public void removeStudent(String id) {
		for (Student stud : studentList) {
			if (stud.getRollNo().toString().equals(id)) {
				studentList.remove(stud);
				return;
			}
		}
		throw new StudentNotFoundException("student not found");
	}

}

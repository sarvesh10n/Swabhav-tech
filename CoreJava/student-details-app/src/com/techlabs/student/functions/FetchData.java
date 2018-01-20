package com.techlabs.student.functions;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.techlabs.student.Student;

public class FetchData {

	public static void fetchData() {
		try {
			FileInputStream is = new FileInputStream("Data/student_data.ser");
			ObjectInputStream ois = new ObjectInputStream(is);
			StudentList.studentList = (ArrayList<Student>) ois.readObject();
			ois.close();
		} catch (Exception e) {
		}
	}
}

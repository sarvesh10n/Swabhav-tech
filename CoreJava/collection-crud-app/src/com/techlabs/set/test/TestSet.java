package com.techlabs.set.test;

import java.util.HashSet;
import com.techlabs.student.Student;

public class TestSet {

	public static void main(String args[]) {
		crudHashSet();
	}

	public static void crudHashSet() {

		// create
		HashSet<Student> studentSet = new HashSet<Student>();

		Student stud1 = new Student("Sarvesh", "Nerurkar", "Bhandup");
		Student stud2 = new Student("Atharv", "Nerurkar", "Bhandup");

		studentSet.add(stud1);
		studentSet.add(stud2);

		// read
		System.out.println(studentSet);

		// update
		Student stud2Updated = new Student("abc", "xyz", "lmn");
		studentSet.remove(stud2);
		studentSet.add(stud2Updated);
		System.out.println(studentSet);
	}
}

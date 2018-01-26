package com.techlabs.student.test;

import com.techlabs.student.*;

import java.lang.reflect.*;
import java.util.concurrent.ConcurrentHashMap;

public class ObjectCreationTest {

	public static void main(String args[]) {

		//objectCreation1();

		objectCreation2();

		//objectCreation3();
	}

	private static void objectCreation1() {
		Student student;
		try {
			student = (Student) Class.forName(
					"com.techlabs.student.Student").newInstance();
			student.setAddress("Bhandup");
			student.setFirstName("Sarvesh");
			student.setLastName("Nerurkar");
			student.displayStudentDetails();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private static void objectCreation2() {
		Student student = new Student();
		try {
			student.setFirstName("Sarvesh");
			student.setLastName("Nerurkar");
			student.setAddress("Bhandup");
			Student studentClone = (Student) student.clone();
			System.out.println(student.hashCode());
			System.out.println(studentClone.hashCode());
			
			studentClone.displayStudentDetails();
		} catch (CloneNotSupportedException e) {

		}

	}

	private static void objectCreation3() {
		try {
			Constructor<Student> constructor = Student.class
					.getDeclaredConstructor();
			
			Student student=constructor.newInstance();
			
			student.setAddress("Bhandup");
			student.setFirstName("Sarvesh");
			student.setLastName("Nerurkar");
			student.displayStudentDetails();

		} catch (Exception e) {

		}
	}

}

package com.techlabs.unit.testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.Test;

import com.techlabs.custom.exceptions.StudentNotFoundException;
import com.techlabs.student.tasks.Student;
import com.techlabs.student.tasks.StudentDataStore;

import static org.junit.Assert.*;

public class UnitTesting {

	@Test
	public void shouldCheckIfStudentIsAddingInAddStudentMethod() {
		StudentDataStore studentDataStore = new StudentDataStore();

		Student student = new Student();
		student.setAddress("thane");
		student.setFirstName("sarvesh");

		int previous_count = studentDataStore.getStudentCount();

		studentDataStore.addStudent(student);

		int new_count = studentDataStore.getStudentCount();

		assertNotEquals(previous_count, new_count);
	}
	@Test
	public void shouldThrowExceptionIfFileNotFound()
	{
		 StudentDataStore studentDataStore = new StudentDataStore();
		 studentDataStore.fetchData();
	}

	 @Test
	 public void shouldSaveAndRetrieveProperly() {
	 StudentDataStore studentDataStore = new StudentDataStore();
	
	 Student student = new Student();
	 student.setAddress("thane");
	 student.setFirstName("sarvesh");
	 student.setLastName("nerurkar");
	
	 studentDataStore.addStudent(student);
	
	 int previous_count = studentDataStore.getStudentCount();
	 studentDataStore.saveData();
	
	 StudentDataStore studentDataStore1 = new StudentDataStore();
	 studentDataStore1.fetchData();
	
	 int new_count = studentDataStore1.getStudentCount();
	 assertEquals(previous_count, new_count);
	 }

	@Test(expected = StudentNotFoundException.class)
	public void shouldThrowExceptionIfRollNoDoesNotMatchInRemoveStudentMethod() {
		StudentDataStore studentDataStore = new StudentDataStore();
		Student student = new Student();
		student.setAddress("andheri");
		student.setFirstName("test");
		student.setLastName("student");
		studentDataStore.addStudent(student);
		int previous_count = studentDataStore.getStudentCount();
		studentDataStore.removeStudent("sdfsdf");
		int new_count = studentDataStore.getStudentCount();
		assertNotEquals(new_count, previous_count);
	}

	@Test(expected = StudentNotFoundException.class)
	public void shouldThrowExceptionIfStudentNotFoundInSearchMethod() {
		StudentDataStore studentDataStore = new StudentDataStore();
		Student student = new Student();
		student.setAddress("andheri");
		student.setFirstName("test");
		student.setLastName("student");
		studentDataStore.addStudent(student);
		
		Iterable<Student> check_student = new ArrayList<Student>();
		check_student = studentDataStore.search("tead");
		int iterator = 0;
		for (Student stud : check_student) {
			iterator++;
		}
		assertNotEquals(iterator, 0);
	}
	

}

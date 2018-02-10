package com.techlabs.unit.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


import org.junit.Test;

import com.techlabs.student.tasks.Student;
import com.techlabs.student.tasks.StudentDataStore;

import static org.junit.Assert.*;

public class StudentDataStoreTest {
	
	@Test
	public void checkAdd()
	{
		StudentDataStore studentDataStore=new StudentDataStore();
		
		Student student=new Student();
		student.setAddress("thane");
		student.setFirstName("sarvesh");
		
		int previous_count=studentDataStore.getStudentCount();
		
		studentDataStore.addStudent(student);
		
		int new_count=studentDataStore.getStudentCount();
		
		assertNotEquals(previous_count, new_count);
	}

	@Test
	public void checkStudentRetrieval()
	{
		StudentDataStore studentDataStore=new StudentDataStore();
		
		Student student=new Student();
		student.setAddress("thane");
		student.setFirstName("sarvesh");
		student.setLastName("nerurkar");
		
		studentDataStore.addStudent(student);
		
		int previous_count=studentDataStore.getStudentCount();
		
		studentDataStore.saveData();
		
		studentDataStore.getList().removeAll(studentDataStore.getList());
		
		studentDataStore.fetchData();
		
		int new_count=studentDataStore.getStudentCount();
		assertEquals(previous_count, new_count);
	}
}

package com.techlabs.repository;

import com.techlabs.model.Student;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
	
	public StudentRepository(){
		System.out.println("Student repository created");
	}
	
	public ArrayList<Student> get(){
		ArrayList<Student> studentList=new ArrayList<>();
		Student s1=new Student();
		s1.setFirstName("sarvesh");
		s1.setLastName("nerurkar");
		s1.setRollNo(1);
		s1.setAddress("bhandup");
		
		Student s2=new Student();
		s2.setFirstName("abhishek");
		s2.setLastName("parab");
		s2.setRollNo(2);
		s2.setAddress("bhandup");
		
		Student s3=new Student();
		s3.setFirstName("akash");
		s3.setLastName("kulkarni");
		s3.setRollNo(3);
		s3.setAddress("thane");
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		
		return studentList;
	}
}

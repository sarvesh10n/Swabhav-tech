package com.techlabs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.model.Student;
import com.techlabs.repository.StudentRepository;

@Service("studentSvc")
public class StudentService {
	
	public  StudentService() {
		System.out.println("Student Service created");
	}
	
	@Autowired
	private StudentRepository repo;
	
	public ArrayList<Student> getStudentList(){
		return repo.get();
	}
}

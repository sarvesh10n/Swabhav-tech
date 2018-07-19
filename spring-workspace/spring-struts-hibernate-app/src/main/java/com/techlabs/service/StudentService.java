package com.techlabs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techlabs.entity.Student;
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
	
	public void addStudent(Student student){
		repo.addStudent(student);
	}

	public Student getStudentForUpdate(int rollNo) {
		return repo.getStudentForUpdate(rollNo);
	}

	public void updateStudent(int rollNo, Student student) {
		repo.updateStudent(rollNo,student);
	}
	public void deleteStudent(int rollNo){
		repo.deleteStudent(rollNo);
	}
}

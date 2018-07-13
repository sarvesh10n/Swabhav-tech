package com.techlabs.actions;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;
import com.techlabs.model.Student;
import com.techlabs.model.StudentService;

public class StudentAction implements Action{

	private ArrayList<Student> studentList=new StudentService().getStudentList();
	
	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String execute() throws Exception {
		
		return this.SUCCESS;
	}
	
	public String displayAddPage()
	{
		return this.NONE;
	}

}

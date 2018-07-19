package com.techlabs.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.entity.Student;
import com.techlabs.service.StudentService;
import com.techlabs.view.model.AddStudentModel;

public class AddStudentAction implements Action,ModelDriven<AddStudentModel>{

	@Autowired
	StudentService studentService;
	
	AddStudentModel addStudModel;
	@Override
	public AddStudentModel getModel() {
		addStudModel=new AddStudentModel();
		return addStudModel;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return this.SUCCESS;
	}
	
	public String addStudent(){
		Student student=new Student();
		student.setFirstName(addStudModel.getFirstName());
		student.setLastName(addStudModel.getLastName());
		student.setAddress(addStudModel.getAddress());
		studentService.addStudent(student);
		return this.SUCCESS;
	}

}

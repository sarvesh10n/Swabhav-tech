package com.techlabs.action;



import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.service.StudentService;
import com.techlabs.view.model.StudentViewModel;

public class DisplayListAction implements ModelDriven<StudentViewModel>,Action{

	@Autowired
	private StudentService studentService;
	StudentViewModel studentVM;
	@Override
	public StudentViewModel getModel() {
		studentVM=new StudentViewModel();
		return studentVM;
	}
	@Override
	public String execute() throws Exception {
		studentVM.setStudentList(studentService.getStudentList());
		System.out.println("executed");
		return this.SUCCESS;
	}
	
	

}

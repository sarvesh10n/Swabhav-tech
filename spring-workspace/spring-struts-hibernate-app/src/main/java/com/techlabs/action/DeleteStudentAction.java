package com.techlabs.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.service.StudentService;
import com.techlabs.view.model.DeleteStudentModel;

public class DeleteStudentAction implements Action,ModelDriven<DeleteStudentModel>{

	@Autowired
	StudentService deleteService;
	
	DeleteStudentModel delModel;
	@Override
	public String execute() throws Exception {
		deleteService.deleteStudent(delModel.getRollNo());
		return this.SUCCESS;
	}

	@Override
	public DeleteStudentModel getModel() {
		delModel=new DeleteStudentModel();
		return delModel;
	}

}

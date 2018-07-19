package com.techlabs.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.model.AdminModel;
import com.techlabs.service.AccountService;

public class AdminAction implements Action,ModelDriven<AdminModel>{

	@Autowired
	AccountService service;
	AdminModel adminModel;
	@Override
	public String execute() throws Exception {
		adminModel.setUserList(service.getUserList());
		return this.SUCCESS;
	}

	@Override
	public AdminModel getModel() {
		adminModel=new AdminModel();
		return adminModel;
	}
	
	public String updateStatus(){
		service.updateStatus(adminModel.getUserId());
		return this.SUCCESS;
	}

}

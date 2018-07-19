package com.techlabs.action;

import java.io.IOException;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.captcha.VerifyRecaptcha;
import com.techlabs.entity.Account;
import com.techlabs.entity.BankUser;
import com.techlabs.entity.Transactions;
import com.techlabs.model.RegisterModel;
import com.techlabs.service.AccountService;

public class RegisterAction extends ActionSupport implements
		ModelDriven<RegisterModel> {

	@Autowired
	AccountService service;
	RegisterModel regModel;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return this.SUCCESS;
	}

	public String registerUser() throws IOException {
		Transactions trans = new Transactions();
		trans.setType("D");
		trans.setAmount(regModel.getAmount());
		trans.setName(regModel.getName());
		trans.setDate(new Date());

		BankUser user = new BankUser();
		user.setName(regModel.getName());
		user.setPassword(regModel.getPassword());
		user.setRole("user");
		user.setStatus(true);

		Account acc = new Account();
		acc.setBalance(regModel.getAmount());
		acc.getTransactionList().add(trans);
		user.setAccount(acc);

		trans.setAccount(acc);
		String gRecaptchaResponse = ServletActionContext.getRequest()
				.getParameter("g-recaptcha-response");
		boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
		if (verify) {
			if (service.AddUser(user))
				return this.SUCCESS;
		}

		addFieldError("registerError", "Username is already in use!!");
		return "register";
	}

	@Override
	public RegisterModel getModel() {
		regModel = new RegisterModel();
		return regModel;
	}

	public String checkName() {
		regModel.setAvailability(service.checkName(regModel.getName()));

		return this.SUCCESS;
	}

}

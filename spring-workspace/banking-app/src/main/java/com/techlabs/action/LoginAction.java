package com.techlabs.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.entity.BankUser;
import com.techlabs.model.LoginModel;
import com.techlabs.service.AccountService;

public class LoginAction extends ActionSupport implements
		ModelDriven<LoginModel>, SessionAware {

	@Autowired
	AccountService service;

	private Map<String, Object> loginSession;

	LoginModel loginMod;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return this.SUCCESS;
	}

	public String validUser() {
		BankUser user = service.validUser(loginMod.getUserName(),
				loginMod.getPassword());
		if (user != null) {

			if (user.getRole().equals("admin")) {
				loginSession.put("userId", user.getUser_id());
				loginSession.put("user", loginMod.getUserName());
				return "admin";

			}
			if (user.isStatus()) {
				loginSession.put("userId", user.getUser_id());
				loginSession.put("user", loginMod.getUserName());
				return this.SUCCESS;
			} else {
				addFieldError("attemptError", "Account is locked");
				return this.LOGIN;
			}
		}
		addFieldError("loginError", "invalid user name or password");
		return this.LOGIN;
	}

	@Override
	public LoginModel getModel() {
		loginMod = new LoginModel();
		return loginMod;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		loginSession = session;
	}
}

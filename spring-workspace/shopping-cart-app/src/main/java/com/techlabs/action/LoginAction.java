package com.techlabs.action;

import java.util.HashSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.entity.LineItem;
import com.techlabs.model.LoginModel;
import com.techlabs.service.CartService;

public class LoginAction extends ActionSupport implements
		ModelDriven<LoginModel>, SessionAware {

	Map<String, Object> loginSession;
	@Autowired
	CartService service;

	LoginModel logMod;

	@Override
	public String execute() throws Exception {
		return this.SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		loginSession = session;
	}

	@Override
	public LoginModel getModel() {
		logMod = new LoginModel();
		return logMod;
	}

	public String validLogin() {
		if (service.validLogin(logMod.getUserName(), logMod.getPassword()) == null) {
			addFieldError("loginError", "Invalid username or password");
			return this.LOGIN;
		}
		loginSession.put("user",logMod.getUserName());
		loginSession.put("lineItems", new HashSet<LineItem>());
		return this.SUCCESS;
	}
}

package com.techlabs.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action,SessionAware{

	private Map<String, Object> loginSession;
	private String name,password;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return this.SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		loginSession=session;
	}
	
	public String validLogin(){
		if(name.equals("sarvesh")&&password.equals("123")){
			loginSession.put("user", "sarvesh");
			return this.SUCCESS;
		}
		else
			return this.ERROR;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

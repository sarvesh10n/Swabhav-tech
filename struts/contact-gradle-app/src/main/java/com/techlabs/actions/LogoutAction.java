package com.techlabs.actions;



import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;

public class LogoutAction implements Action,SessionAware {

	private Map<String, Object> loginSession;
	@Override
	public String execute() throws Exception {
		if (loginSession != null) {
			loginSession.clear();
		}// TODO Auto-generated method stub
		return this.SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		loginSession=session;
		
	}

}

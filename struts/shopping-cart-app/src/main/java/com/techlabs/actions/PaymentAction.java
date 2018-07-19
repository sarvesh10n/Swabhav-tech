package com.techlabs.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;

public class PaymentAction implements Action, SessionAware {

	Map<String, Object> session;

	@Override
	public String execute() throws Exception {
		if (session.isEmpty()) {
			return this.LOGIN;
		}
		return this.SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}

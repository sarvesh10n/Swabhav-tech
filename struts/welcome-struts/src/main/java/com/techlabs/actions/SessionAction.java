package com.techlabs.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class SessionAction extends ActionSupport implements SessionAware {

	private Map<String, Object> sessionMap;
	private Integer oldCount;
	private Integer newCount;
	//public static final String HELLO_COUNT = "helloCount";

	public Integer getOldCount() {
		return oldCount;
	}
	public Integer getNewCount() {
		return newCount;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		sessionMap = session;

	}
	
	@Override
	public String execute() {
		oldCount=(Integer) sessionMap.get("count");
		increaseHelloCount();
		newCount=(Integer) sessionMap.get("count");
		return this.SUCCESS;
	}

	private void increaseHelloCount() {
		Integer helloCount = (Integer) sessionMap.get("count");

		if (helloCount == null) {
			helloCount = 1;
		} else {
			helloCount++;
		}

		sessionMap.put("count", helloCount);
	}

}

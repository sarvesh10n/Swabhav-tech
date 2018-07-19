package com.techlabs.interceptor;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	Map<String, Object> loginSession;

	public String intercept(ActionInvocation invocation) throws Exception {
		loginSession=invocation.getInvocationContext().getSession();
		if (loginSession.isEmpty())
			return "loginPage";
		
		return invocation.invoke();
	}

	public void destroy() {
		System.out.println("Destroying MyLoggingInterceptor...");
	}

	public void init() {
		System.out.println("Initializing MyLoggingInterceptor...");
	}
}

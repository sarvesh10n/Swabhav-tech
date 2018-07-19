package com.techlabs.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.model.DisplayModel;
import com.techlabs.service.AccountService;

public class DisplayPassbookAction implements Action, ModelDriven<DisplayModel> ,SessionAware{

	private Map<String,Object> loginSession;
	
	@Autowired
	AccountService service;

	DisplayModel dispModel;

	@Override
	public String execute() throws Exception {
		String userId=null;
		if(loginSession.get("userId")!=null)
			userId=loginSession.get("userId").toString();
		if(userId==null){
			return this.ERROR;
		}
		dispModel.setTransactionList(service
				.getTransactionList(userId));
		return this.SUCCESS;
	}

	@Override
	public DisplayModel getModel() {
		dispModel = new DisplayModel();
		return dispModel;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		loginSession=session;
	}

}

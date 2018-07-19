package com.techlabs.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.model.WDModel;
import com.techlabs.service.AccountService;

public class WithdrawDepositAction extends ActionSupport implements SessionAware,
		ModelDriven<WDModel> {

	@Autowired
	AccountService service;
	WDModel wdModel;
	Map<String, Object> loginSession;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return this.SUCCESS;
	}

	public String withdrawDeposit() {
		if(service.withdrawDeposit(loginSession.get("userId").toString(),
				wdModel.getType(), wdModel.getAmount()))
		return this.SUCCESS;
		else{
			addFieldError("transError", "Insufficient balance!! Check balance and try again");
			return this.ERROR;
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		loginSession = session;
	}

	@Override
	public WDModel getModel() {
		wdModel = new WDModel();
		return wdModel;
	}

}

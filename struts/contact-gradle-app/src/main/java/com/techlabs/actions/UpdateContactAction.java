package com.techlabs.actions;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.techlabs.model.Contact;
import com.techlabs.model.ContactService;

public class UpdateContactAction implements Action,SessionAware{

	private String guid;
	private Contact contact;
	private Map<String,Object> loginSession;
	
	@Override
	public void setSession(Map<String, Object> session) {
		loginSession=session;
		
	}
	
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	
	public String updateContact(){
		new ContactService().updateContact(guid,contact);
		return this.SUCCESS;
	}
	
	
	//Contact contact=new ContactService().getUpdateContact("");
	@Override
	public String execute() throws Exception {
		if(loginSession.isEmpty()){
			return this.LOGIN;
		}
		contact=new ContactService().getUpdateContact(guid);
		return this.SUCCESS;
	}
	

}

package com.techlabs.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.model.Contact;
import com.techlabs.model.ContactService;

public class AddContactAction extends ActionSupport implements SessionAware{

	private Contact contact;
	private Map<String, Object> loginSession;
	
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

	public String addContact() {
		new ContactService().addContactList(contact);
		return this.SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		if (loginSession.isEmpty()) {
			return this.LOGIN;
		}
		return this.SUCCESS;
	}

	

}

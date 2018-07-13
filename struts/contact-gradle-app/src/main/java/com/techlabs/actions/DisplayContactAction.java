package com.techlabs.actions;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;
import com.techlabs.model.Contact;
import com.techlabs.model.ContactService;

public class DisplayContactAction implements Action{

	private ArrayList<Contact> contactList=new ContactService().getContactList();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return this.SUCCESS;
	}

	public ArrayList<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(ArrayList<Contact> contactList) {
		this.contactList = contactList;
	}



}

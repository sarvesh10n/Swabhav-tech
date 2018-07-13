package com.techlabs.model;

import java.util.ArrayList;

public class ContactService {
	
	private static ArrayList<Contact> contactList=new ArrayList<>();
	
	public ContactService(){
	}

	public void addContactList(Contact contact){
		contactList.add(contact);
	}
	
	public ArrayList<Contact> getContactList(){
		return contactList;
	}

	public Contact getUpdateContact(String guid) {
		for(Contact c:contactList){
			if(c.getId().equals(guid)){
				return c;
			}
		}
		return null;
	}

	public void updateContact(String id,Contact contact) {
		int i=0;
		for(Contact c:contactList){
			if(c.getId().equals(id)){
				break;
			}
			i++;
		}
		contactList.set(i,contact);
	}
}

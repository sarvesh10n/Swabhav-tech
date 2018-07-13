package com.techlabs.model;

import java.util.ArrayList;

import sun.font.CreatedFontTracker;

import com.techlabs.contacts.Contact;

public class ContactsProvider {
	
	private static ContactsProvider myObj;

	private ContactsProvider() {
	}

	public static ContactsProvider getInstance(){
        if(myObj == null){
            myObj = new ContactsProvider();
        }
        return myObj;
    }
	ArrayList<Contact> contacts=new ArrayList<Contact>();
	
	public ArrayList getContacts(){
		return contacts;
	}

	public void addStudent(Contact c) {
		this.contacts.add(c);
	}

	public void updateStudent(String id, Contact contact) {
		int i=0;
		for(Contact c:contacts){
			if(c.getId().equals(id)){
				break;
			}
			i++;
		}
		contacts.set(i,contact);
	}
	
	
}

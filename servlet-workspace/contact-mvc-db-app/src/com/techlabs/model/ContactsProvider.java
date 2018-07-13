package com.techlabs.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import sun.font.CreatedFontTracker;

import com.techlabs.contact.datastore.ContactDataStore;
import com.techlabs.contacts.Contact;
import com.techlabs.contacts.ContactDto;

public class ContactsProvider {
	
	private static ContactsProvider myObj;
	ContactDataStore contactDataStore;

	private ContactsProvider() {
	}
	public void getConnection() throws ClassNotFoundException, IOException{
		contactDataStore=new ContactDataStore();
	}

	public static ContactsProvider getInstance(){
        if(myObj == null){
            myObj = new ContactsProvider();
        }
        return myObj;
    }
	ArrayList<Contact> contacts=new ArrayList<Contact>();
	
	public ArrayList<ContactDto> getContacts() throws SQLException{
		return contactDataStore.getContacts();
	}

	public void addStudent(Contact c) throws SQLException {
		contactDataStore.addContact(c);
	}

	public void updateStudent(String id, Contact contact) throws SQLException {
		contactDataStore.updateStudent(id,contact);
	}
	public Contact getContactForUpdate(String id) throws SQLException {
		return contactDataStore.getUpdateContact(id);
	}
	
	
}

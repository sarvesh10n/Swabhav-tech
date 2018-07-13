package com.techlabs.contact.datastore;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.techlabs.contacts.Contact;
import com.techlabs.contacts.ContactDto;

public class ContactDataStore {
	Connection conn = null;

	public ContactDataStore() throws ClassNotFoundException, IOException {
		conn=new Connections().getConnection();
	}
	
	public ArrayList<ContactDto> getContacts() throws SQLException{
		ArrayList<ContactDto> contactList=new ArrayList<>();
		String query="select* from contacts";
		PreparedStatement preparedStatement=(PreparedStatement) conn.prepareStatement(query);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			String id=resultSet.getString("id");
			String name=resultSet.getString("name");
			String phone=resultSet.getString("phone");
			String email=resultSet.getString("email");
			ContactDto contact=new ContactDto(id,name, phone, email);
			contactList.add(contact);
		}
		return contactList;
	}
	
	public void addContact(Contact contact) throws SQLException{
		String query="insert into contacts values(?,?,?,?)";
		PreparedStatement preparedStatement=(PreparedStatement) conn.prepareStatement(query);
		preparedStatement.setString(1, contact.getId());
		preparedStatement.setString(2, contact.getName().toString());
		preparedStatement.setString(3, contact.getPhone());
		preparedStatement.setString(4, contact.getEmail());
		preparedStatement.executeUpdate();
	}

	public void updateStudent(String id, Contact contact) throws SQLException {
		String query="update contacts set name=?,phone=?,email=? where id=?";
		PreparedStatement preparedStatement=(PreparedStatement) conn.prepareStatement(query);
		preparedStatement.setString(1, contact.getName().toString());
		preparedStatement.setString(2, contact.getPhone());
		preparedStatement.setString(3, contact.getEmail());
		preparedStatement.setString(4, id);
		preparedStatement.executeUpdate();
		
	}

	public Contact getUpdateContact(String id) throws SQLException {
		Contact contact=null;
		String query="select name,phone,email from contacts where id=?";
		PreparedStatement preparedStatement=(PreparedStatement) conn.prepareStatement(query);
		preparedStatement.setString(1, id);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			String name=resultSet.getString("name");
			String phone=resultSet.getString("phone");
			String email=resultSet.getString("email");
			contact=new Contact(name, phone, email);
		}
		return contact;
	}
}

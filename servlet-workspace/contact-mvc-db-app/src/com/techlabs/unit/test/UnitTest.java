package com.techlabs.unit.test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.techlabs.contact.datastore.ContactDataStore;
import com.techlabs.contacts.Contact;

public class UnitTest {

	@Test
	public void checkConnection() throws SQLException, ClassNotFoundException, IOException{
		ContactDataStore contactDataStore=new ContactDataStore();
	}
}

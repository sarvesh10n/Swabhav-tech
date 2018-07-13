package com.techlabs.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpServer;
import com.techlabs.contact.datastore.LoginDataStore;

public class LoginService {
	
	public LoginService() throws ClassNotFoundException, IOException{
		LoginDataStore loginDataStore=new LoginDataStore();

	}
			
	public boolean validUser(String userName,String password) throws SQLException{
		return LoginDataStore.validUser(userName,password);
	}
}

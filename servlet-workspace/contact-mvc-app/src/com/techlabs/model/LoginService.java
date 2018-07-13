package com.techlabs.model;

import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpServer;

public class LoginService {
	private static LoginService myObj;

	
	private LoginService(){
		
	}
	
	public static LoginService getInstance(){
        if(myObj == null){
            myObj = new LoginService();
        }
        return myObj;
    }
	
	
	public boolean validUser(String userName,String password){
		if(userName.equals("sarvesh")&&password.equals("123"))
		{
			return true;
		}
		return false;
	}
}

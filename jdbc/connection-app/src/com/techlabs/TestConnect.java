package com.techlabs;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class TestConnect {

	public static void main(String args[]){
		Connection conn=null;
		try{
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/techlabs?"+"user=root&password=123456");
			System.out.println(conn.getClass());
			System.out.println("Connection done succesfully!!");
			System.out.println("Database name is "+conn.getCatalog());
		}
		catch(SQLException ex){
			System.out.println("SQLException: "+ex.getMessage());
			System.out.println("SQLState: "+ex.getSQLState());
			System.out.println("VenderError: "+ex.getErrorCode());
		}
	}
}

package com.techlabs.contact.datastore;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class LoginDataStore {

	static Connection conn;

	public LoginDataStore() throws ClassNotFoundException, IOException {
		conn = new Connections().getConnection();
	}

	public static boolean validUser(String userName, String password)
			throws SQLException {
		String query = "select * from login where username=? and password=?";
		PreparedStatement preparedStatement = (PreparedStatement) conn
				.prepareStatement(query);
		preparedStatement.setString(1, userName);
		preparedStatement.setString(2, password);
		ResultSet rs=preparedStatement.executeQuery();
		System.out.println(rs.isBeforeFirst());
		if(!rs.isBeforeFirst()){
			return false;
		}
		return true;
	}

}

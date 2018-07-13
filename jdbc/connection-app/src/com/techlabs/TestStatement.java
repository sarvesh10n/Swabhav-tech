package com.techlabs;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TestStatement {

	public static void main(String args[]) {
		Connection conn = null;
		try {
			conn = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost/techlabs?"
							+ "user=root&password=123456");
			System.out.println("Connection completed successfully\n");
			Statement stmt = (Statement) conn.createStatement();
			String query = "select * from dept;";
			ResultSet resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
				System.out.print(resultSet.getString(1)+" ");
				System.out.print(resultSet.getString(2)+" ");
				System.out.print(resultSet.getString(3)+" ");
				System.out.println();
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VenderError: " + ex.getErrorCode());
		}
	}
}

package com.techlabs;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TestStatement {

	public static void main(String args[]) throws ClassNotFoundException {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:8090;DatabaseName=aurionpro;integratedSecurity=true");

			Statement stmt = (Statement) conn.createStatement();
			String query = "select * from dept;";
			ResultSet resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
				System.out.print(resultSet.getString(1) + " ");
				System.out.print(resultSet.getString(2) + " ");
				System.out.print(resultSet.getString(3) + " ");
				System.out.println();
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VenderError: " + ex.getErrorCode());
		}
	}
}

package com.techlabs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TestSqlInject {
	public static void main(String args[]) throws NumberFormatException,
			IOException {
		Connection conn = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			conn = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:4040/techlabs?allowMultiQueries=true&"
							+ "user=root&password=123456");
			System.out.println("Connection done successfully\n");
			System.out.println("Enter the DeptNo");
			String input = br.readLine();
			Statement stmt = (Statement) conn.createStatement();
			String query = "select * from DEPT where DEPTNO=" + input;
			ResultSet resultSet = stmt.executeQuery(query);
			if (!resultSet.isBeforeFirst()) {
				System.out.println("No record found");
			}
			while (resultSet.next()) {
				System.out.print("Department number is "
						+ resultSet.getString("DEPTNO") + "\n"
						+ "Department name is " + resultSet.getString("DNAME")
						+ "\n" + "Department location is "
						+ resultSet.getString("LOC"));
				System.out.println();
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}
}

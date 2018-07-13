package com.techlabs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class SqlInjectSoln {
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
			String query = "select * from DEPT where DEPTNO=?";
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(query);
			preparedStatement.setString(1, input);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
				System.out.println("No record found");
			}
			while (resultSet.next()) {
				System.out.print("Department number is "
						+ resultSet.getInt("DEPTNO") + "\n"
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

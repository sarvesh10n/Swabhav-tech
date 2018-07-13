package com.techlabs.transaction.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class TransactionTest {
	
	public static void main(String args[]) throws NumberFormatException, IOException, SQLException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Connection conn=null;
		try{
		conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:4040/techlabs?user=root&password=123456");
		System.out.println("Connection done succesfully");
		System.out.println("Enter the amount to be transfered");
		double amount=Double.parseDouble(br.readLine());
		
		String query1="UPDATE CUSTOMER SET AMOUNT=AMOUNT-? WHERE NAME=?";
		String query2="UPDATE MERCHANT SET AMOUNT=AMOUNT+? WHERE NAME"
				+ "=?";
		PreparedStatement ps1=(PreparedStatement) conn.prepareStatement(query1);
		PreparedStatement ps2=(PreparedStatement) conn.prepareStatement(query2);
		conn.setAutoCommit(false);
		ps1.setDouble(1, amount);
		ps1.setString(2,"sarvesh");
		ps2.setDouble(1, amount);
		ps2.setString(2,"santosh");

		ps1.executeUpdate();
		ps2.executeUpdate();
		conn.commit();
		System.out.println("Transaction done succesfully");
		}
		catch(SQLException e){
			System.out.println(e);
			conn.rollback();
			System.out.println("Successfully rolled back");
		}
		
	}
}

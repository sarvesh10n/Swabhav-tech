package com.techlabs.datastore;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.techlabs.connection.MakeConnection;
import com.techlabs.model.Account;

public class AccountDataStore {

	public boolean checkLogin(String name,String password) throws ClassNotFoundException, IOException, SQLException{
		MakeConnection makeConnection=new MakeConnection();
		Connection conn=makeConnection.getConnection();
		String query="SELECT * FROM BANK_MASTER WHERE NAME=? AND PASSWORD=?";
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		if(!rs.isBeforeFirst()){
			conn.close();
			return false;
		}
		conn.close();
		return true;
	}
	
	public void register(Account account) throws ClassNotFoundException, IOException, SQLException{
		Connection conn=new MakeConnection().getConnection();
		String name=account.getName();
		String password=account.getPassword();
		String balance=account.getBalance();
		try{	
			
		conn.setAutoCommit(false);
		
		String query1="INSERT INTO BANK_MASTER VALUES(?,?,?)";
		PreparedStatement ps1=(PreparedStatement) conn.prepareStatement(query1);
		ps1.setString(1, name);
		ps1.setString(2, password);
		ps1.setDouble(3, Double.parseDouble(balance));
		ps1.executeUpdate();
		String query2="INSERT INTO BANK_TRANSACTION(NAME,AMOUNT,TYPE) VALUES(?,?,?)";
		PreparedStatement ps2=(PreparedStatement) conn.prepareStatement(query2);
		ps2.setString(1, name);
		ps2.setDouble(2, Double.parseDouble(balance));
		ps2.setString(3, "D");
		ps2.executeUpdate();
		conn.commit();
		conn.close();
		}
		catch(SQLException e){
			conn.rollback();
			System.out.println(e);
		}
	}
}

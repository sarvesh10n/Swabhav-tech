package com.techlabs.datastore;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.techlabs.connection.MakeConnection;
import com.techlabs.model.Transaction;

public class TransactionDataStore {

	Connection conn;

	public TransactionDataStore() throws ClassNotFoundException, IOException {
		conn = new MakeConnection().getConnection();
	}

	public ArrayList<Transaction> getTransactionRecord(String user)
			throws SQLException, ClassNotFoundException, IOException {
		ArrayList<Transaction> transactions = new ArrayList<>();
		String query = "SELECT * FROM BANK_TRANSACTION WHERE NAME=?";
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
		ps.setString(1, user);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String name = rs.getString("NAME");
			String amount = rs.getDouble("AMOUNT") + "";
			String type = rs.getString("TYPE");
			String date = rs.getDate("DATE") + "";
			Transaction tr = new Transaction(name, amount, type, date);
			transactions.add(tr);
		}

		return transactions;

	}

	public boolean withdrawDeposit(String name, double amount, String type) throws SQLException {
		try {
			conn.setAutoCommit(false);
			String query2;
			String query1 = "INSERT INTO BANK_TRANSACTION(NAME,AMOUNT,TYPE) VALUES(?,?,?)";
			
			PreparedStatement ps1 = (PreparedStatement) conn
					.prepareStatement(query1);
			ps1.setString(1, name);
			ps1.setDouble(2, amount);
			ps1.setString(3, type);
			ps1.executeUpdate();
			if(type.equals("W")){
				 query2 = "UPDATE BANK_MASTER SET BALANCE=BALANCE-? WHERE NAME=?";	
			}
			else
				 query2 = "UPDATE BANK_MASTER SET BALANCE=BALANCE+? WHERE NAME=?";	
			PreparedStatement ps2=(PreparedStatement) conn.prepareStatement(query2);
			ps2.setDouble(1, amount);
			ps2.setString(2, name);
			
			ps2.executeUpdate();
			conn.commit();
			conn.close();
			return true;
		} catch (SQLException e) {
			conn.rollback();
			conn.close();
			System.out.println(e);
			return false;
		}
	}
}

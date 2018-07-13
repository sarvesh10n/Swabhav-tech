package com.techlabs.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import com.techlabs.datastore.TransactionDataStore;

public class TransactionService {

	public ArrayList<Transaction> getTransactionRecord(String user) throws ClassNotFoundException, SQLException, IOException{
		TransactionDataStore transactionDataStore=new TransactionDataStore();
		return(transactionDataStore.getTransactionRecord(user));
	}
	
	public boolean withdrawDeposit(String name,double amount,String type) throws ClassNotFoundException, IOException, SQLException{
		return new TransactionDataStore().withdrawDeposit(name, amount, type);
	}
}

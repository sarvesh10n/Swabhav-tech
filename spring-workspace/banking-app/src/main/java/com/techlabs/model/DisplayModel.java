package com.techlabs.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.techlabs.entity.Transactions;

public class DisplayModel {

	private Set<Transactions> transactionList=new HashSet<>();

	public Set<Transactions> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(Set<Transactions> transactionList) {
		this.transactionList = transactionList;
	}




	
}


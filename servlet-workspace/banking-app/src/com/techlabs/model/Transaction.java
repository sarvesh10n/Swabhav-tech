package com.techlabs.model;

public class Transaction {
	private String name;
	private String amount;
	private String type;
	private String date;
	
	public Transaction(String name, String amount, String type, String date) {
		super();
		this.name = name;
		this.amount = amount;
		this.type = type;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	public String getAmount() {
		return amount;
	}
	public String getType() {
		return type;
	}
	public String getDate() {
		return date;
	}
}

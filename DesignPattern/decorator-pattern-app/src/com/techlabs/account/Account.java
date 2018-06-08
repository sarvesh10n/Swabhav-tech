package com.techlabs.account;

import com.techlabs.interfaces.IAccount;

public class Account implements IAccount{

	private double balance;
	private String name;
	private int id;
	
	public Account(double balance, String name, int id) {
		super();
		this.balance = balance;
		this.name = name;
		this.id = id;
	}
	
	@Override
	public void deposit(double amt) {
		balance+=amt;
	}
}

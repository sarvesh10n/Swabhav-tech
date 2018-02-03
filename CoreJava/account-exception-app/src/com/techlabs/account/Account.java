package com.techlabs.account;

public class Account {

	private static final double MINIMUM_BALANCE = 500;
	private static int noOfAccounts;
	private final int accNo;
	private final String name;
	private double balance;
	
	
	static{
		noOfAccounts=100;
		System.out.println("Inside static block");
	}

	public Account(int accNo, String name, double balance) {
		this.accNo = accNo;
		this.name = name;
		this.balance = balance;
		noOfAccounts++;
		System.out.println("Inside constructor");
	}

	public Account(int accNo, String name) {
		this(accNo, name, 500);
	}

	public int getAccNo() {
		return accNo;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public boolean withdraw(double amount) {
		return ((balance - amount) > MINIMUM_BALANCE);
	}

	public  int getNumberofAccountsCount() {
		return noOfAccounts;
	}
	
	public static int getHeadCount() {
		return noOfAccounts;}
	

}

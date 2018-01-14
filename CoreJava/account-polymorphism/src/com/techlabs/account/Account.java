package com.techlabs.account;

public abstract class Account {

	protected static int accCounter;
	protected static int withdrawCount;
	protected static int depositCount;
	protected final int accNo;
	protected final String name;
	protected double balance;

	static {
		accCounter = 0;
		withdrawCount = 0;
		depositCount = 0;
	}

	public Account(String name, double balance) {
		accCounter = accCounter + 1;
		this.accNo = accCounter;
		this.name = name;
		this.balance = balance;
	}

	public void deposit(double amount) {
		balance += amount;
		trackDeposits();
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

	protected void trackWithdrawals() {
		withdrawCount++;
	}

	protected void trackDeposits() {
		depositCount++;
	}

	public static int getWithdrawCount() {
		return withdrawCount;
	}
	public static int getDepositCount()
	{
		return depositCount;
	}

	public abstract void withdraw(double amount);

}

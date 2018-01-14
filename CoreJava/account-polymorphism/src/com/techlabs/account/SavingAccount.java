package com.techlabs.account;

public class SavingAccount extends Account {
	private static final double MINIMUM_BALANCE;

	static {
		MINIMUM_BALANCE = 500;
	}

	public SavingAccount(String name, double balance) {
		super(name, balance);
	}

	public void withdraw(double amount) {
		if ((balance - amount) > MINIMUM_BALANCE) {
			balance = balance - amount;
			trackWithdrawals();
		} else
			throw new InsufficientBalanceException("Insufficient balance");

	}

	public double getMinimumBalance() {
		return MINIMUM_BALANCE;
	}

}

package com.techlabs.account;

public class CurrentAccount extends Account {

	private static final int MINIMUM_BALANCE;

	static {
		MINIMUM_BALANCE = -1000;
	}

	public CurrentAccount(String name, double balance) {
		super(name, balance);
	}

	public void withdraw(double amount) {

		if (balance - amount > MINIMUM_BALANCE) {
			balance = balance - amount;
			trackWithdrawals();
		} else
			try{
			throw new InsufficientBalanceException(this,amount);}
		catch(Exception e)
		{System.out.println(e);}
	}

}

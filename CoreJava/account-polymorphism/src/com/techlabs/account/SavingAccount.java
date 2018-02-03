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
			try {
				throw new InsufficientBalanceException(this, amount);
			} catch (InsufficientBalanceException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.println(e);
			}

	}

	public double getMinimumBalance() {
		return MINIMUM_BALANCE;
	}

}

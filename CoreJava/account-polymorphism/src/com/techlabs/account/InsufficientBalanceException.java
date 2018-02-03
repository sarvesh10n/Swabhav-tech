package com.techlabs.account;

public class InsufficientBalanceException extends Exception{
	
	private Account acc;
	private double amount;
	
	public InsufficientBalanceException(Account s,double amount) {
		acc=s;
		this.amount=amount;
		
	}
	
	@Override
	public String getMessage()
	{
		
		return "Name is "+acc.getName()+", acc no is "+acc.getAccNo()+" and balance is "+acc.getBalance()+" you are trying to withdraw "+amount;
	}

}

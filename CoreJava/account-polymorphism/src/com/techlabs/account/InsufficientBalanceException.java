package com.techlabs.account;

public class InsufficientBalanceException extends RuntimeException{
	
	public InsufficientBalanceException(String s) {
		super(s);
	}

}

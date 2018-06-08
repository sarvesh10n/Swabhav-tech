package com.techlabs.account.listener;

import com.techlabs.account.Account;
import com.techlabs.account.listener.interfac.IAccountListener;

public class SmsAccountListener implements IAccountListener{

	@Override
	public void balanceChanged(Account acc) {
		System.out.println("Balance of "+acc.getName()+" is changed to "+acc.getAmount()+" sms sent to "+acc.getPhoneNo());
	}

}

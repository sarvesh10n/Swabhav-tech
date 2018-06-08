package com.techlabs.listener.test;

import com.techlabs.account.Account;
import com.techlabs.account.listener.EmailAccountListener;
import com.techlabs.account.listener.SmsAccountListener;

public class ListenerTest {
	
	public static void main(String args[])
	{
		Account acc1=new Account(101, "Sarvesh", 5000, "9646231356", "sarvesh10n@gmail.com");
		acc1.addListener(new EmailAccountListener());
		acc1.addListener(new SmsAccountListener());
		
		acc1.deposit(100);
		System.out.println(acc1.getAmount());
	}
	

}

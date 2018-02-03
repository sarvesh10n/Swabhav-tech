package com.techlabs.account.test;
import com.techlabs.account.*;

public class AccountTest {

	public static void main(String args[])
	{
		Account acc1=new Account(98978886,"Sarvesh");
		System.out.println("Number of accounts are "+acc1.getNumberofAccountsCount());
		Account acc2=new Account(98978996,"Santosh",1000);
		System.out.println("Number of accounts are "+acc2.getNumberofAccountsCount());
		
		System.out.println(Account.getHeadCount());
		/*printDetails(acc1);
		
		printDetails(acc2);
		
		
		acc1.deposit(1000);
		acc2.deposit(200);
		
		printDetails(acc1);
		printDetails(acc2);
		
		if(acc1.withdraw(500))
			printDetails(acc1);
		else 
			System.out.println("Inufficient balance");
		
		if(acc2.withdraw(500))
			printDetails(acc2);
		else 
			System.out.println("Inufficient balance");*/
	}
	
	public static void printDetails(Account acc)
	{
		System.out.println("Account number is: "+acc.getAccNo());
		System.out.println("Name is "+acc.getName());
		System.out.println("Current balance is "+acc.getBalance());
		System.out.println();
	}
}

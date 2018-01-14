package com.techlabs.account.test;
import com.techlabs.account.*;

public class TestAccount {

	public static void main(String args[])
	{
		CurrentAccount currentAccount=new CurrentAccount("Sarvesh",2000);
		SavingAccount savingAccount=new SavingAccount("santosh", 5000);
		
		printDetails(currentAccount);
		printDetails(savingAccount);
		
		currentAccount.deposit(500);
		savingAccount.deposit(1000);
		currentAccount.withdraw(2500);
		savingAccount.withdraw(2000);
		
		System.out.println("After withdrawal");
		
		printDetails(currentAccount);
		printDetails(savingAccount);
	}
	
	public static void printDetails(Account account)
	{
		System.out.println("Account number is "+account.getAccNo());
		System.out.println("Name is "+account.getName());
		System.out.println("Balance is "+account.getBalance());
		
		System.out.println("Total number of deposits are: "+Account.getDepositCount());
		System.out.println("Total number of withdrawals are: "+Account.getWithdrawCount());
		
	}
}

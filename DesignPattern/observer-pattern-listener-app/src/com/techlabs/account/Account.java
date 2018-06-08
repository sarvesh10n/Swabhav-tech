package com.techlabs.account;

import java.util.ArrayList;
import java.util.List;

import com.techlabs.account.listener.interfac.IAccountListener;

public class Account {

	private int id;
	private String name;
	private double amount;
	private String phoneNo;
	private String emailId;
	private List<IAccountListener> listener;

	public Account(int id, String name, double salary, String phoneNo,
			String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.amount = salary;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		listener = new ArrayList<IAccountListener>();
	}

	public void addListener(IAccountListener accountListener) {
		listener.add(accountListener);
	}

	public void deposit(double amount) {
		this.amount += amount;
		informListener();
	}

	private void informListener() {
		for (IAccountListener listen : listener) {
			listen.balanceChanged(this);
		}
	}

	public List<IAccountListener> getListener() {
		return listener;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getAmount() {
		return amount;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

}

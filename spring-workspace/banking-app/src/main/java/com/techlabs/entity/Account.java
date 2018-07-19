package com.techlabs.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Account {
	
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2") 
    @Id
	private String acc_id;
	
	@OneToMany(mappedBy="account",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Transactions> transactionList=new HashSet<>();
	
	private double balance;
	
	public Set<Transactions> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(Set<Transactions> transactionList) {
		this.transactionList = transactionList;
	}
	public String getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
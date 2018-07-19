package com.techlabs.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.velocity.util.introspection.UberspectImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.entity.Account;
import com.techlabs.entity.BankUser;
import com.techlabs.entity.Transactions;
import com.techlabs.model.RegisterModel;
import com.techlabs.repository.AccountRepo;

@Service("accountService")
public class AccountService {
	
	public AccountService(){
		System.out.println("Account service created");
	}

	@Autowired
	private AccountRepo repo;
	
	public boolean AddUser(BankUser user){
		return repo.addUser(user);
	}

	public  Set<Transactions> getTransactionList(String user_id) {
		return repo.getTransactionList(user_id);
	}

	public BankUser validUser(String userName, String password) {
		return repo.validUser(userName,password);
	}

	public boolean withdrawDeposit(String userId, String type, double amount) {
		return repo.withdrawDeposit(userId,type,amount);
	}

	public List<BankUser> getUserList() {
		return repo.getUserList();
	}

	public void updateStatus(String userId) {
		repo.updateStatus(userId);
	}

	public boolean checkName(String name) {
		return repo.checkName(name);
		
	}
}

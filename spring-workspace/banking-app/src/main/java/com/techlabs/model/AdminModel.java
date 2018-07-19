package com.techlabs.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.techlabs.entity.BankUser;

public class AdminModel {
	
	private List<BankUser> userList=new ArrayList<>();
	private String userId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<BankUser> getUserList() {
		return userList;
	}

	public void setUserList(List<BankUser> userList) {
		this.userList = userList;
	}

}

package com.techlabs.model;

import java.io.IOException;
import java.sql.SQLException;

import com.techlabs.datastore.AccountDataStore;

public class AccountService {

	AccountDataStore loginDataStore = new AccountDataStore();

	public boolean checkLogin(String name, String password)
			throws ClassNotFoundException, IOException, SQLException {

		return (loginDataStore.checkLogin(name, password));
	}

	public void register(Account account)
			throws ClassNotFoundException, IOException, SQLException {
		new AccountDataStore().register(account);
	}
}

package com.techlabs.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.techlabs.entity.Account;
import com.techlabs.entity.Transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.entity.BankUser;

@Repository
public class AccountRepo {

	@Autowired
	private SessionFactory factory;
	private Session session = null;
	private Transaction txn = null;

	List<BankUser> userList = new ArrayList<>();
	Set<Transactions> transactionList = new HashSet<>();

	public AccountRepo() {
		System.out.println("Repository created");
	}

	public boolean addUser(BankUser user) {
		userList.add(user);

		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			session.save(user);
			txn.commit();
		} catch (HibernateException e) {
			System.out.println(e);
			txn.rollback();
			return false;
		} finally {
			session.close();
		}
		return true;

	}

	public Set<Transactions> getTransactionList(String user_id) {
		try {

			session = factory.openSession();
			txn = session.beginTransaction();
			BankUser user = (BankUser) session.get(BankUser.class, user_id);
			transactionList = user.getAccount().getTransactionList();
			txn.commit();
			System.out.println("data displayed");
		} catch (HibernateException e) {
			System.out.println(e);
			txn.rollback();
		} finally {
			session.close();
		}
		return transactionList;

	}

	public BankUser validUser(String userName, String password) {
		{
			BankUser user = null;
			try {
				session = factory.openSession();
				txn = session.beginTransaction();
				String hql = "from BankUser where name=:username and password=:password";
				System.out.println(hql);
				Query query = session.createQuery(hql);
				query.setParameter("username", userName);
				query.setParameter("password", password);
				List result = query.list();
				if (result.size() >= 1)
					user = (BankUser) result.get(0);

			} catch (HibernateException e) {
				System.out.println(e);
				txn.rollback();
			} finally {
				session.close();
			}
			return user;
		}
	}

	public boolean withdrawDeposit(String userId, String type, double amount) {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			BankUser user = (BankUser) session.get(BankUser.class, userId);
			Account acc = user.getAccount();
			Transactions transaction = new Transactions();
			double balance = acc.getBalance();
			if (type.equals("W")) {

				if (balance - amount < 1000) {
					return false;
				}
				acc.setBalance(balance - amount);
			} else
				acc.setBalance(balance + amount);

			transaction.setAccount(acc);
			transaction.setAmount(amount);
			transaction.setDate(new Date());
			transaction.setName(user.getName());
			transaction.setType(type);
			acc.getTransactionList().add(transaction);

			session.save(user);
			txn.commit();

		} catch (HibernateException e) {
			System.out.println(e);
			txn.rollback();
		} finally {
			session.close();
		}
		return true;
	}

	public List<BankUser> getUserList() {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			String hql = "from BankUser where role=:role";
			System.out.println(hql);
			Query query = session.createQuery(hql);
			query.setParameter("role", "user");
			userList = query.list();

		} catch (HibernateException e) {
			System.out.println(e);
			txn.rollback();
		} finally {
			session.close();
		}
		return userList;
	}

	public void updateStatus(String userId) {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			BankUser user = (BankUser) session.get(BankUser.class, userId);
			user.setStatus(!user.isStatus());
			session.save(user);
			txn.commit();

		} catch (HibernateException e) {
			System.out.println(e);
			txn.rollback();
		} finally {
			session.close();
		}
	}

	public boolean checkName(String name) {
		 boolean availability=false;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			String hql = "from BankUser where name=:name";
			System.out.println(hql);
			Query query = session.createQuery(hql);
			query.setParameter("name", name);
			if(query.list().size()==1)
				availability=true;
			else
				availability=false;

		} catch (HibernateException e) {
			System.out.println(e);
			txn.rollback();
		} finally {
			session.close();
		}
		return availability;
	}
}

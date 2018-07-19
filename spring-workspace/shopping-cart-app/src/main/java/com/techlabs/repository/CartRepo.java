package com.techlabs.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.entity.Customer;
import com.techlabs.entity.Order;
import com.techlabs.entity.Product;

@Repository
public class CartRepo {
	@Autowired
	private SessionFactory factory;
	private Session session = null;
	private Transaction txn = null;

	List<Product> productList = new ArrayList<>();

	public CartRepo() {
		System.out.println("Cart repo created");
	}

	public List<Product> getProductList() {
		try {

			session = factory.openSession();
			txn = session.beginTransaction();

			Criteria criteria = session.createCriteria(Product.class);
			productList = criteria.list();
			System.out.println("Product List fetched");
			txn.commit();
			System.out.println("data displayed");
		} catch (HibernateException e) {
			System.out.println(e);
			txn.rollback();
		} finally {
			session.close();
		}
		return productList;
	}

	public String validLogin(String userName, String password) {
		String userId = null;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			String hql = "select customerId from Customer where name=:username and password=:password";
			System.out.println(hql);
			Query query = session.createQuery(hql);
			query.setParameter("username", userName);
			query.setParameter("password", password);
			List result = query.list();
			if (result.size() >= 1)
				userId = result.get(0).toString();

		} catch (HibernateException e) {
			System.out.println(e);
			txn.rollback();
		} finally {
			session.close();
		}
		return userId;
	}

	public Product getProduct(String productId) {
		Product prod = null;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			prod = (Product) session.get(Product.class, productId);

		} catch (HibernateException e) {
			System.out.println(e);
			txn.rollback();
		} finally {
			session.close();
		}
		return prod;
	}

	public void checkout(Order order, String name) {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			String hql = "from Customer where name=:username";
			System.out.println(hql);
			Query query = session.createQuery(hql);
			query.setParameter("username", name);
			List result = query.list();
			Customer customer=(Customer) result.get(0);
			order.setCustomer(customer);
			customer.getOrders().add(order);
			session.save(customer);
			txn.commit();
			
		} catch (HibernateException e) {
			System.out.println(e);
			txn.rollback();
		} finally {
			session.close();
		}
	}
}

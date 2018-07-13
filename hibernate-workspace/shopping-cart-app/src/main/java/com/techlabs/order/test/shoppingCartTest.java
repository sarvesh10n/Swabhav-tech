package com.techlabs.order.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.techlabs.order.Customer;
import com.techlabs.order.LineItem;
import com.techlabs.order.Order;
import com.techlabs.order.Product;

public class shoppingCartTest {

	private static Transaction txn=null;
	private static Session session=null;
	public static void main(String args[]){
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		
		SessionFactory factory=config.buildSessionFactory();
		System.out.println(factory.getClass());
		
		try{
			session=factory.openSession();
			txn=session.beginTransaction();
			
			Product product1=new Product();
			product1.setName("Cake");
			product1.setPrice(500);
			
			
			Product product2=new Product();
			product2.setName("Milk");
			product2.setPrice(50);
			
			Customer customer1=new Customer();
			customer1.setName("sarvesh");
			
			Order order=new Order();
			order.setDate(new Date());
			order.setCustomer(customer1);
			
			LineItem lineItem1=new LineItem();
			lineItem1.setProduct(product1);
			lineItem1.setQty(2);
			lineItem1.setOrder(order);
			
			LineItem lineItem2=new LineItem();
			lineItem2.setProduct(product2);
			lineItem2.setQty(4);
			lineItem2.setOrder(order);
			
			Set<LineItem>lineItemList=new HashSet<LineItem>();
			lineItemList.add(lineItem1);
			lineItemList.add(lineItem2);
			
			order.setItems(lineItemList);
			
			Set<Order> orderList=new HashSet<>();
			orderList.add(order);
			
			customer1.setOrders(orderList);
			
			session.save(customer1);
			txn.commit();
		}
		catch(HibernateException e){
			System.out.println(e);
			txn.rollback();
		}
		finally{
			session.close();
		}
	}
}

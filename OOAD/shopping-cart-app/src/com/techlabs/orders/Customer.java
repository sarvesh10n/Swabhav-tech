package com.techlabs.orders;

import java.util.ArrayList;

public class Customer {

	private static int id_count;
	private int customerId;
	private String name;
	private ArrayList<Order> orders = new ArrayList<Order>();

	static {
		id_count = 1;
	}

	public Customer(String name) {
		customerId = id_count++;
		this.name = name;
	}

	public void addOrder(Order order) {
		orders.add(order);
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return name;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}
}

package com.techlabs.order.test;
import java.util.Date;

import com.techlabs.order.*;
import com.techlabs.orders.Customer;
import com.techlabs.orders.LineItem;
import com.techlabs.orders.Order;
import com.techlabs.orders.Product;

public class TestProduct {

	public static void main(String args[])
	{
		Product product1=new Product("milk", 10);
		Product product2=new Product("coffee", 15,10);
		LineItem lineItem1=new LineItem(product1, 2);
		LineItem lineItem2=new LineItem(product2, 5);
		LineItem lineItem3=new LineItem(product1,2);

		
		Order order1=new Order(new java.util.Date(System.currentTimeMillis()));
		order1.addItem(lineItem1);
		order1.addItem(lineItem2);
		order1.addItem(lineItem3);
		
		Order order2=new Order(new java.util.Date(System.currentTimeMillis()));
		order2.addItem(lineItem1);
		order2.addItem(lineItem2);
		
		Customer customer=new Customer("sarvesh");
		customer.addOrder(order1);
		customer.addOrder(order2);
		displayOrderDetails(customer);
	}

	public static void displayOrderDetails(Customer customer)
	{
		System.out.println();
		for(Order order:customer.getOrders())
		{
			System.out.println("Customer Name: "+customer.getCustomerName());
			System.out.println("Customer Id: "+customer.getCustomerId());
			
			System.out.println("Order Id: "+order.getOrderId());
			System.out.println("-----------------------------order---------------------------------");
			System.out.println("Date: "+order.getOrderDate());
			System.out.println();
			System.out.println("PId\tPName\tprice\tdisc\tDprice\tQty\tTprice");
			for(LineItem item:order.getLineItem())
			{
				System.out.print(item.getProduct().getId()+"\t");
				System.out.print(item.getProduct().getName()+"\t");
				System.out.print(item.getProduct().getPrice()+"\t");
				System.out.print(item.getProduct().calculateDiscountCost()+"\t");
				System.out.print(item.getProduct().getPrice()-item.getProduct().calculateDiscountCost()+"\t");
				System.out.print(item.getQuantity()+"\t");		
				System.out.print(item.calculateItemCost()+"\t");
				System.out.println();
			}
			System.out.println("----------------------------------------------------------------------");
			System.out.println("Total Cost:\t\t\t\t\t "+order.checkOutPrice());
			System.out.println("----------------------------------------------------------------------");

			
		}
		
	}
}

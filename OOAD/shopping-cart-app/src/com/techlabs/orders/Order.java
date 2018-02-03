package com.techlabs.orders;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Order {

	private static int id_count;
	private int orderId;
	private Date date;
	private ArrayList<LineItem> items = new ArrayList<LineItem>();

	static {
		id_count = 1;
	}

	public Order(Date date) {
		orderId = id_count++;
		this.date = date;
	}

	public void addItem(LineItem lineItem) {
		boolean flag=true;
		for(LineItem item:items)
		{
			if(item.getProduct().getId()==lineItem.getProduct().getId())
			{
				item.setQuantity(lineItem.getQuantity()+item.getQuantity());
				flag=false;
			}
		}
		if(flag==true)
			items.add(lineItem);
	}

	public double checkOutPrice() {
		double price = 0;
		Iterator i = items.iterator();
		while (i.hasNext()) {
			LineItem item = (LineItem) i.next();
			price = price + item.calculateItemCost();
		}
		return price;
	}

	public int getOrderId() {
		return orderId;
	}

	public Date getOrderDate() {
		return date;
	}

	public ArrayList<LineItem> getLineItem() {
		return items;
	}
}

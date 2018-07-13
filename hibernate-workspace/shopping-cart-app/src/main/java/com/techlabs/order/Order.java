package com.techlabs.order;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="ORDERS")
public class Order {

	@Id @GeneratedValue
	private int orderId;
	private Date date;
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	private Set<LineItem> items = new HashSet<LineItem>();
	
	@ManyToOne
	@JoinColumn
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void addItem(LineItem lineItem) {
		boolean flag = true;
		for (LineItem item : items) {
			if (item.getProduct().getProductId() == lineItem.getProduct()
					.getProductId()) {
				item.setQty(lineItem.getQty() + item.getQty());
				flag = false;
			}
		}
		if (flag == true)
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

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<LineItem> getItems() {
		return items;
	}

	public void setItems(Set<LineItem> items) {
		this.items = items;
	}


}

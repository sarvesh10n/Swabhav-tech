package com.techlabs.order;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class LineItem {

	@Id
	@GeneratedValue
	private int lineItemId;
	
	@ManyToOne
	@JoinColumn
	private Order order;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private Product product;
	private int qty;

	public double calculateItemCost() {
		return ((product.getPrice() - product.calculateDiscountCost()) * qty);
	}

	public int getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(int lineItemId) {
		this.lineItemId = lineItemId;
	}

	public Product getProduct() {
		return product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}

package com.techlabs.orders;

public class LineItem {

	private static int id_count;
	private int lineItemId;
	private Product product;
	private int qty;

	static {
		id_count = 1;
	}

	public LineItem(Product product, int qty) {
		this.product = product;
		this.qty = qty;
		this.lineItemId = id_count++;
	}

	public double calculateItemCost() {
		return ((product.getPrice() - product.calculateDiscountCost()) * qty);
	}

	public int getId() {
		return lineItemId;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return qty;
	}
	public void setQuantity(int quantity)
	{
		qty=quantity;
	}
}

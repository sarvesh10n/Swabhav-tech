package com.techlabs.orders;

public class Product {

	private static int id_count;
	private int productId;
	private String name;
	private double price;
	private double discountPercentage;

	static {
		id_count = 1;
	}

	public Product(String name, double price, double discountPercentage) {
		this.name = name;
		this.price = price;
		this.discountPercentage = discountPercentage;
		productId = id_count++;
	}

	public Product(String name, double price) {
		this(name, price, 0);
	}

	public double calculateDiscountCost() {
		return (discountPercentage / 100) * price;
	}

	public int getId() {
		return productId;
	}

	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
}

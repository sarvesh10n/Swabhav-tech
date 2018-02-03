package com.techlabs.collection;

public class LineItem implements Comparable<LineItem> {

	private int id;
	private String name;
	private int quantity;
	private double unitPrice;

	@Override
	public int compareTo(LineItem item) {
		return id-item.id;
	}

	public LineItem(int id, String name, int quantity, double unitPrice) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public double calcTotalCost() {
		return quantity * unitPrice;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}

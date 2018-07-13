package com.techlabs.model;

public class Order {

	private LineItem lineItem;
	private String date;
	
	public LineItem getLineItem() {
		return lineItem;
	}
	public void setLineItem(LineItem lineItem) {
		this.lineItem = lineItem;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}

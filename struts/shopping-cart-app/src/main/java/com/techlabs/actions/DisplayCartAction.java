package com.techlabs.actions;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;
import com.techlabs.model.LineItem;
import com.techlabs.model.Product;
import com.techlabs.model.ProductService;

public class DisplayCartAction implements Action {

	ProductService productService = ProductService.getInstance();

	private ArrayList<Product> productList = productService.getProductList();
	private ArrayList<LineItem> lineItemList = productService.getLineItemList();
	private LineItem lineItem;
	private String selected;
	private String quantity;
	private double totalAmount;
	private double displayAmount;

	public double getDisplayAmount() {
		return displayAmount;
	}

	public void setDisplayAmount(double displayAmount) {
		this.displayAmount = displayAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LineItem getLineItem() {
		return lineItem;
	}

	public void setLineItem(LineItem lineItem) {
		this.lineItem = lineItem;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public ArrayList<LineItem> getLineItemList() {
		return lineItemList;
	}

	public void setLineItemList(ArrayList<LineItem> lineItemList) {
		this.lineItemList = lineItemList;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return this.SUCCESS;
	}

	public String addToCart() {

		Product product = productService.getProduct(selected);
		lineItem = new LineItem();
		lineItem.setProduct(product);
		double unitPrice = product.getProductPrice();
		lineItem.setQuantity(Double.parseDouble(quantity));
		totalAmount = unitPrice * Double.parseDouble(quantity);
		lineItem.setTotalPrice(totalAmount);
		productService.addLineItem(lineItem);
		return this.SUCCESS;
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

}

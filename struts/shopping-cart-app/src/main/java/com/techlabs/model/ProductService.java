package com.techlabs.model;

import java.util.ArrayList;

public class ProductService {

	private static ProductService productService = null;

	private ProductService() {
		Product prod1 = new Product();
		prod1.setProductName("Iphone");
		prod1.setProductPrice(50000);
		productList.add(prod1);

		Product prod2 = new Product();
		prod2.setProductName("MI3");
		prod2.setProductPrice(40000);
		productList.add(prod2);

		Product prod3 = new Product();
		prod3.setProductName("Samsung");
		prod3.setProductPrice(30000);
		productList.add(prod3);

		Product prod4 = new Product();
		prod4.setProductName("Oppo");
		prod4.setProductPrice(20000);
		productList.add(prod4);
	}

	public static ProductService getInstance() {
		if (productService == null)
			productService= new ProductService();
		return productService;
	}

	private ArrayList<Product> productList = new ArrayList<>();
	private ArrayList<LineItem> lineItemList = new ArrayList<>();

	public static ProductService getProductService() {
		return productService;
	}

	public static void setProductService(ProductService productService) {
		ProductService.productService = productService;
	}

	public ArrayList<LineItem> getLineItemList() {
		return lineItemList;
	}

	public void setLineItemList(ArrayList<LineItem> lineItemList) {
		this.lineItemList = lineItemList;
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	public Product getProduct(String selected) {
		for (Product p : productList) {
			if (p.getProductId().equals(selected)) {
				System.out.println(p.getProductPrice());
				return p;
			}
		}
		return null;
	}

	public void addLineItem(LineItem lineItem) {
		for (LineItem lItem : lineItemList) {
			if (lItem.getProduct().equals(lineItem.getProduct())) {
				int index = lineItemList.indexOf(lItem);
				double totalQuantity = lItem.getQuantity()
						+ lineItem.getQuantity();
				double totalPrice = lItem.getTotalPrice()
						+ lineItem.getTotalPrice();
				lineItem.setQuantity(totalQuantity);
				lineItem.setTotalPrice(totalPrice);
				lineItemList.set(index, lineItem);
				return;
			}
		}
		lineItemList.add(lineItem);

	}

}

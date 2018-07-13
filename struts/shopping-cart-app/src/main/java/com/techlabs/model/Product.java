package com.techlabs.model;
import java.util.UUID;

public class Product {
		
		private String productId=UUID.randomUUID().toString();
		private String productName;
		private double productPrice;
		public String getProductId() {
			return productId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public double getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(double productPrice) {
			this.productPrice = productPrice;
		}

		
}

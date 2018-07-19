package com.techlabs.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.entity.Order;
import com.techlabs.entity.Product;
import com.techlabs.repository.CartRepo;

@Service
public class CartService {
	
	
	@Autowired
	CartRepo repo;
	
	public CartService(){
		System.out.println("Cart service created");
	}
	
	public List<Product> getProductList(){
		return repo.getProductList();
	}

	public String validLogin(String userName, String password) {
		return repo.validLogin(userName,password);
	}

	public Product getProduct(String productId) {
		return repo.getProduct(productId);
	}

	public void checkout(Order order, String name) {
		repo.checkout(order,name);
		
	}
}

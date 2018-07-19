package com.techlabs.action;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.entity.LineItem;
import com.techlabs.entity.Order;
import com.techlabs.service.CartService;

public class CheckoutAction implements Action,SessionAware{

	@Autowired
	CartService service;
	
	Map<String, Object> loginSession;
	@Override
	public void setSession(Map<String, Object> session) {
		loginSession=session;
	}

	@Override
	public String execute() throws Exception {
		double totalAmount=0;
		HashSet<LineItem> lineItems=(HashSet<LineItem>) loginSession.get("lineItems");
		Order order=new Order();
		order.setDate(new Date());
		for(LineItem l:lineItems){
			l.setOrder(order);
			totalAmount+=l.calculateTotalCost();
		}
		order.setTotalPrice(totalAmount);
		
		order.setItems(lineItems);
		service.checkout(order,loginSession.get("user").toString());
		lineItems.clear();
		loginSession.put("lineItems", lineItems);
		return this.SUCCESS;
	}

}

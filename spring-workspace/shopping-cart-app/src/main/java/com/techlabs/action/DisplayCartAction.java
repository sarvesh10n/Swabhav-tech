package com.techlabs.action;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.entity.LineItem;
import com.techlabs.entity.Product;
import com.techlabs.model.DisplayModel;
import com.techlabs.service.CartService;

public class DisplayCartAction extends ActionSupport implements
		ModelDriven<DisplayModel>, SessionAware {

	Map<String, Object> loginSession;
	@Autowired
	CartService service;
	DisplayModel dispModel;

	@Override
	public String execute() throws Exception {
		dispModel.setProductList(service.getProductList());
		return this.SUCCESS;
	}

	@Override
	public DisplayModel getModel() {
		dispModel = new DisplayModel();
		return dispModel;
	}

	public String addToCart() {
		Product product = service.getProduct(dispModel.getSelected());
		HashSet<LineItem> lineItems = (HashSet<LineItem>) loginSession
				.get("lineItems");
		for (LineItem lineItem : lineItems) {
			if (lineItem.getProduct().getProductId()
					.equals(product.getProductId())) {
				lineItems.remove(lineItem);
				lineItem.setQty(lineItem.getQty() + dispModel.getQuantity());
				lineItems.add(lineItem);
				return this.SUCCESS;
			}
		}

		LineItem lineItem = new LineItem();
		lineItem.setProduct(product);
		lineItem.setQty(dispModel.getQuantity());

		lineItems.add(lineItem);
		loginSession.put("lineItems", lineItems);

		return this.SUCCESS;
	}

	public String getCurrentCost() {
		dispModel.setTotalCost(service.getProduct(dispModel.getSelected())
				.getPrice() * dispModel.getQuantity());
		System.out.println("quantity is "+dispModel.getQuantity());
		return this.SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		loginSession = session;
	}

}

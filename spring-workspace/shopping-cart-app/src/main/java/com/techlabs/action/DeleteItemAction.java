package com.techlabs.action;

import java.util.HashSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.entity.LineItem;
import com.techlabs.model.DeleteModel;

public class DeleteItemAction implements Action,SessionAware,ModelDriven<DeleteModel>{

	DeleteModel delMod;
	
	private static final Object LineItem = null;
	Map<String,Object> loginSession;
	@Override
	public void setSession(Map<String, Object> session) {
		loginSession=session;
	}

	@Override
	public String execute() throws Exception {
		HashSet<LineItem> lineItems=(HashSet<LineItem>) loginSession.get("lineItems");
		for(LineItem l:lineItems){
			if(l.getProduct().getProductId().equals(delMod.getLineItemId())){
				lineItems.remove(l);
			}
		}
		return this.SUCCESS;
	}
	@Override
	public DeleteModel getModel() {
		delMod=new DeleteModel();
		return delMod;
	}

}

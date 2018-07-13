package com.techlabs.actions;

import java.util.Date;

import com.opensymphony.xwork2.Action;

public class BrowseAction implements Action{

	private String date="10-09-1996";
	
	private String methodType;
	private String mType="false";
		
	public String getDate(){
		return this.date;
	}
	
	public void setmType(String value){
		mType=value;
	}
	
	public String getMethodType(){
		if(mType.equals("false"))
			methodType="get";
		else
			methodType="post";
		return methodType;
	}
	
	@Override
	public String execute() throws Exception {
		return this.SUCCESS;
	}

}

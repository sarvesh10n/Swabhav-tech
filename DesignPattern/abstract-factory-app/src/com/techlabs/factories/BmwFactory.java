package com.techlabs.factories;

import com.techlabs.automobile.bmw.BmwHatchback;
import com.techlabs.automobile.bmw.BmwSedan;
import com.techlabs.automobile.bmw.BmwSuv;
import com.techlabs.interfaces.IAuto;
import com.techlabs.interfaces.IAutomobileFactory;

public class BmwFactory implements IAutomobileFactory{

	private static BmwFactory bmwFactory;
	
	private  BmwFactory()
	{}
	
	
	@Override
	public IAuto makeSuv() {
		return new BmwSuv();
	}

	@Override
	public IAuto makeSedan() {
		return new BmwSedan();
	}

	@Override
	public IAuto makeHatchback() {
		return new BmwHatchback();
	}
	
	public static BmwFactory getInstance()
	{
		if(bmwFactory==null)
			bmwFactory=new BmwFactory();
		
		return bmwFactory;
	}

}

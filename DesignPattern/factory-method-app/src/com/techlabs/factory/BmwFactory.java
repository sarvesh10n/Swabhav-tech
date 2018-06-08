package com.techlabs.factory;

import com.techlabs.cars.Bmw;
import com.techlabs.interfaces.IAutoFactory;
import com.techlabs.interfaces.IAutoMobile;

public class BmwFactory implements IAutoFactory{
	
	private BmwFactory(){
		
	}

	private static BmwFactory bmwFactory;
	@Override
	public IAutoMobile make() {
		// TODO Auto-generated method stub
		return new Bmw();
	}
	
	public static IAutoFactory getInstance()
	{
		if(bmwFactory==null)
			bmwFactory=new BmwFactory();
		return bmwFactory;
	}

}

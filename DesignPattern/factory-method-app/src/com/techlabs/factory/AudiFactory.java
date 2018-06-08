package com.techlabs.factory;

import com.techlabs.cars.Audi;
import com.techlabs.interfaces.IAutoFactory;
import com.techlabs.interfaces.IAutoMobile;

public class AudiFactory implements IAutoFactory {

	private static AudiFactory audiFactory;
	
	private AudiFactory() {
	}

	@Override
	public IAutoMobile make() {
		return new Audi();
	}

	public static IAutoFactory getInstance()
	{
		if(audiFactory==null)
			audiFactory=new AudiFactory();
		return audiFactory;
	}
}

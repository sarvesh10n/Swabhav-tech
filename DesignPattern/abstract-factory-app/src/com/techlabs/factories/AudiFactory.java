package com.techlabs.factories;

import com.techlabs.automobile.audi.AudiHatchback;
import com.techlabs.automobile.audi.AudiSedan;
import com.techlabs.automobile.audi.AudiSuv;
import com.techlabs.interfaces.IAuto;
import com.techlabs.interfaces.IAutomobileFactory;

public class AudiFactory implements IAutomobileFactory{
	
	private static AudiFactory audiFactory;
	
	private AudiFactory()
	{}

	@Override
	public IAuto makeSuv() {
		return new AudiSuv();
	}

	@Override
	public IAuto makeSedan() {
		return new AudiSedan();
	}

	@Override
	public IAuto makeHatchback() {
		return new AudiHatchback();
	}
	
	public static AudiFactory getInstance()
	{
		if(audiFactory==null)
			audiFactory=new AudiFactory();
		
		return audiFactory;
	}

}

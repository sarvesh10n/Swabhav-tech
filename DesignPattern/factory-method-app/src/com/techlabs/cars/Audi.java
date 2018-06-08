package com.techlabs.cars;

import com.techlabs.interfaces.IAutoMobile;

public class Audi implements IAutoMobile{

	@Override
	public void start() {
		System.out.println("Audi Started");
		
	}

	@Override
	public void stop() {
		System.out.println("Audi Stopped");
		
	}

}

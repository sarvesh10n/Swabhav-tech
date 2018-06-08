package com.techlabs.cars;

import com.techlabs.interfaces.IAutomobile;

public class Audi implements IAutomobile{

	@Override
	public void start() {
		System.out.println("Audi Started");
		
	}

	@Override
	public void stop() {
		System.out.println("Audi Stopped");
		
	}

}

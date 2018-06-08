package com.techlabs.cars;

import com.techlabs.interfaces.IAutomobile;

public class Tesla implements IAutomobile{

	@Override
	public void start() {
		System.out.println("Tesla Started");
		
	}

	@Override
	public void stop() {
		System.out.println("Tesla Stopped");
		
	}

}

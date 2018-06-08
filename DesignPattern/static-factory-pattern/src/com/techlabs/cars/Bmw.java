package com.techlabs.cars;

import com.techlabs.interfaces.IAutomobile;

public class Bmw implements IAutomobile{

	@Override
	public void start() {
		System.out.println("BMW Started");
	}

	@Override
	public void stop() {
		System.out.println("Bmw Stopped");
	}

}

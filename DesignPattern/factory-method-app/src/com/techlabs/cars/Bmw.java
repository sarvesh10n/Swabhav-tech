package com.techlabs.cars;

import com.techlabs.interfaces.IAutoMobile;

public class Bmw implements IAutoMobile{

	@Override
	public void start() {
		System.out.println("BMW Started");
	}

	@Override
	public void stop() {
		System.out.println("Bmw Stopped");
	}

}

package com.techlabs.automobile.bmw;

import com.techlabs.interfaces.IAuto;

public class BmwHatchback implements IAuto{

	@Override
	public void start() {
		System.out.println("Bmw hatchback started");
		
	}

	@Override
	public void stop() {
		System.out.println("Bmw hatchback stopped");
	}

}

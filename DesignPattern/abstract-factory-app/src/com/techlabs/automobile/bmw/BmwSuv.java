package com.techlabs.automobile.bmw;

import com.techlabs.interfaces.IAuto;

public class BmwSuv implements IAuto{

	@Override
	public void start() {
		System.out.println("Bmw suv started");
		
	}

	@Override
	public void stop() {
		System.out.println("Bmw suv stopped");
		
	}

}

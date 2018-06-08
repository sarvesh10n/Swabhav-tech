package com.techlabs.automobile.audi;

import com.techlabs.interfaces.IAuto;

public class AudiSuv implements IAuto{

	@Override
	public void start() {
		System.out.println("Audi suv started");

		
	}

	@Override
	public void stop() {
		System.out.println("Audi suv stopped");

	}

}

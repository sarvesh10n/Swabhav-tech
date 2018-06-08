package com.techlabs.automobile.audi;

import com.techlabs.interfaces.IAuto;

public class AudiHatchback implements IAuto{

	@Override
	public void start() {
		System.out.println("Audi hatchback started");
		
	}

	@Override
	public void stop() {
		System.out.println("Audi hatchback stopped");
	}

}

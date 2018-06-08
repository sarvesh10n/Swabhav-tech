package com.techlabs.automobile.audi;

import com.techlabs.interfaces.IAuto;

public class AudiSedan implements IAuto{

	@Override
	public void start() {
		System.out.println("Audi sedan started");

	}

	@Override
	public void stop() {
		System.out.println("Audi sedan stopped");

		
	}

}

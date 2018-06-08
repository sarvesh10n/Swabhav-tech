package com.techlabs.automobile.bmw;

import com.techlabs.interfaces.IAuto;

public class BmwSedan implements IAuto{

	@Override
	public void start() {
		System.out.println("Bmw sedan started");
	}

	@Override
	public void stop() {
		System.out.println("Bmw sedan stopped");
	}

}

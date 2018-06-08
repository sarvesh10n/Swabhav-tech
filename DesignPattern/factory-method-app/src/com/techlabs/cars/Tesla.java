package com.techlabs.cars;

import com.techlabs.interfaces.IAutoFactory;
import com.techlabs.interfaces.IAutoMobile;

public class Tesla implements IAutoMobile{

	@Override
	public void start() {
		System.out.println("Tesla Started");
		
	}

	@Override
	public void stop() {
		System.out.println("Tesla Stopped");
		
	}

}

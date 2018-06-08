package com.techlabs.factory;

import com.techlabs.cars.Tesla;
import com.techlabs.interfaces.IAutoFactory;
import com.techlabs.interfaces.IAutoMobile;

public class TeslaFactory implements IAutoFactory {

	private TeslaFactory() {

	}

	private static TeslaFactory teslaFactory;

	@Override
	public IAutoMobile make() {
		// TODO Auto-generated method stub
		return new Tesla();
	}

	public static IAutoFactory getInstance() {
		if (teslaFactory == null)
			teslaFactory = new TeslaFactory();
		return teslaFactory;
	}

}

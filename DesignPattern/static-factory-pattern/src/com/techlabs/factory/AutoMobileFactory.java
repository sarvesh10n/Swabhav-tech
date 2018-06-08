package com.techlabs.factory;

import com.techlabs.cars.Audi;
import com.techlabs.cars.Bmw;
import com.techlabs.cars.Tesla;
import com.techlabs.interfaces.IAutomobile;

public class AutoMobileFactory {

	private AutoMobileFactory() {

	}

	static IAutomobile car;

	public static IAutomobile make(AutoType autoType) {

		if (autoType == AutoType.BMW) {
			car = new Bmw();
		} else if (autoType == AutoType.AUDI) {
			car = new Audi();
		} else if (autoType == AutoType.TESLA) {
			car = new Tesla();
		}
		return car;
	}
}

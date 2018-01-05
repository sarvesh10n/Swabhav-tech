package com.techlabs.inheritance.test;

import com.techlabs.inheritance.Car;

public class CarTest {

	public static void main(String args[]) {

		Car car=new Car();
		car.gearMode="manual";
		car.make="Tata";
		car.speed=100;
		car.average=10;
		System.out.println(car.calculateLitreRequired(2));
	}
}

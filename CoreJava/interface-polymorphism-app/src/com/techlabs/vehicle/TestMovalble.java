package com.techlabs.vehicle;

public class TestMovalble {
	public static void main(String args[]) {
		
	IMovable imovable[]=new IMovable[3];
	imovable[0]=new Car();
	imovable[1]=new Bike();
	imovable[2]=new Truck();
	startRace(imovable);
	
	}

	public static void startRace(IMovable[] movable) {
		System.out.println("Race starts");
		for (IMovable moves : movable) {
			moves.move();
		}

		System.out.println("Race ends");
	}

}

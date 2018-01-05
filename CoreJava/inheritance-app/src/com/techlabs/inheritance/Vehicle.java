package com.techlabs.inheritance;

public class Vehicle {

		public int speed;
		public String make;
		public int average;
		
		public int calculateLitreRequired(int distance)
		{	
			return distance*average;
		}
}

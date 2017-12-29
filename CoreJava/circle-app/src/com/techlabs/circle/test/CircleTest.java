package com.techlabs.circle.test;

import com.techlabs.circle.BorderStyleOption;
import com.techlabs.circle.BorderStyleOption.borderStyleOption;
import com.techlabs.circle.Circle;

public class CircleTest {
	public static void main(String args[]) {

		Circle c1 = new Circle(2.5f);
		Circle c2 = new Circle(3.0f, borderStyleOption.DOTTED);
		 
		printDetails(c1);
		printDetails(c2);
		
		Circle[] circles=new Circle[3];
		circles[0]=new Circle();
		circles[1]=new Circle(2.5f);
		circles[2]=new Circle(4.5f,borderStyleOption.DOUBLE);
		
		for(Circle circle:circles){
			printDetails(circle);
		}
		
		
		
	}
	public static void printDetails(Circle circle)
	{
		System.out.println(circle.hashCode());
		System.out.println(circle.getRadius());
		System.out.println(circle.getBorderStyle());
		System.out.println(circle.calculateArea());
	}
}

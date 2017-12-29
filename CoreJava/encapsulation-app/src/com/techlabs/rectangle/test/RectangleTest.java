package com.techlabs.rectangle.test;

import com.techlabs.rectangle.Rectangle;

public class RectangleTest {
	public static void main(String args[]) {

		Rectangle rect1 = new Rectangle();
		rect1.setHeight(20);
		rect1.setWidth(-10);
		rect1.setBorderColor("Red");
		printDetails(rect1);

		Rectangle rect2 = new Rectangle();
		rect2.setHeight(50);
		rect2.setWidth(50);
		rect2.setBorderColor("Blue");
		printDetails(rect2);
		
		/*Rectangle rect3 = rect1;
		rect3.setHeight(10);
		rect3.setWidth(10);
		rect3.setBorderColor("Green");
		rect3=null;*/
		printDetails(new Rectangle());
		
		
	}

	public static void printDetails(Rectangle rectangle) {
		System.out.println(rectangle.hashCode());
		System.out.println("Width is " + rectangle.getHeight());
		System.out.println("Height is " + rectangle.getWidth());
		System.out.println("Area is " + rectangle.calculateArea());
		System.out.println("Border color is " + rectangle.getBorderColor());
		System.out.println();
	}
}

package com.techlabs.count;

import java.lang.reflect.*;

public class CountTest {

	public static void main(String args[]) {
		countOfMethods(Rectangle.class);
	}

	public static void countOfMethods(Class countMethods) {
		int noOfGetters = 0,noOfSetters=0,noOfConstructors=0,otherMethods=0;
		Method[] methods = countMethods.getDeclaredMethods();
		for (Method method : methods) {
			String methodName = method.getName();
			if (methodName.startsWith("get"))
				noOfGetters++;
			else if (methodName.startsWith("set"))
				noOfSetters++;
			else if(methodName.startsWith("Rectangle"))
				noOfConstructors++;
			else otherMethods++;

		}
		System.out.println("No of getter methods are: "+noOfGetters);
		System.out.println("No of setter methods are: "+noOfSetters);
		System.out.println("No of constructors are: "+noOfConstructors);
		System.out.println("No of getter methods are: "+otherMethods);
	}
}

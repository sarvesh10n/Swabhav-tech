package com.techlabs.count;

import java.lang.reflect.*;

public class CountTest {

	public static void main(String args[]) {
		noOfGettersOf(Rectangle.class);
	}

	public static void noOfGettersOf(Class clazz) {
		int noOfGetters = 0,noOfSetters=0,noOfConstructor=0,otherMethods=0;
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			String methodName = method.getName();
			if (methodName.startsWith("get"))
				noOfGetters++;
			else if (methodName.startsWith("set"))
				noOfSetters++;
			else if(methodName.startsWith("Rectangle"))
				noOfConstructor++;
			else otherMethods++;

		}
		System.out.println("No of getter methods are: "+noOfGetters);
		System.out.println("No of setter methods are: "+noOfSetters);
		System.out.println("No of constructor are: "+noOfConstructor);
		System.out.println("No of getter methods are: "+otherMethods);
	}
}

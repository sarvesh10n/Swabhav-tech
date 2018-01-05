package com.techlabs.count.test;

import java.lang.reflect.*;

import com.techlabs.count.NeedRefactorLater;
import com.techlabs.count.Rectangle;

public class CountTest {

	public static void main(String args[]) {
		countOfMethods(Rectangle.class);

		countAnnotations(Rectangle.class);
	}

	public static void countAnnotations(Class countAnnotation) {
		int noOfAnnotation=0;
		Method[] methods = countAnnotation.getDeclaredMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(NeedRefactorLater.class))
				noOfAnnotation++;
		}
		
		System.out.println("No of annotations are "+noOfAnnotation);

	}

	public static void countOfMethods(Class countMethods) {
		int noOfGetters = 0, noOfSetters = 0, noOfConstructors = 0, otherMethods = 0;
		Method[] methods = countMethods.getDeclaredMethods();
		for (Method method : methods) {
			String methodName = method.getName();
			if (methodName.startsWith("get"))
				noOfGetters++;
			else if (methodName.startsWith("set"))
				noOfSetters++;
			else if (methodName.startsWith("Rectangle"))
				noOfConstructors++;
			else
				otherMethods++;

		}
		System.out.println("No of getter methods are: " + noOfGetters);
		System.out.println("No of setter methods are: " + noOfSetters);
		System.out.println("No of constructors are: " + noOfConstructors);
		System.out.println("No of getter methods are: " + otherMethods);
	}
}

package com.techlabs.singleton;

public class Singleton {

	private static Singleton instance = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance() {
		return instance;
	}

	public void displayMessage() {
		System.out.println("Single object instance");
	}
}

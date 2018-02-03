package com.techlabs.interfaces;

public class Man implements IMannerable {

	@Override
	public void wish() {
		System.out.println("Man says hello");
	}

	@Override
	public void depart() {
		System.out.println("Man depart");
	}
}

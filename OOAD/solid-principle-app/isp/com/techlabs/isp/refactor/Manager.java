package com.techlabs.isp.refactor;

public class Manager implements IEatable,IWorkable {

	@Override
	public void startWork() {
		System.out.println("Manager start working");

	}

	@Override
	public void stopWork() {
		System.out.println("Manager stop working");
	}

	@Override
	public void startEat() {
		System.out.println("Manager start eating");
	}

	@Override
	public void stopEat() {
		System.out.println("Manager stop eating");
	}

}

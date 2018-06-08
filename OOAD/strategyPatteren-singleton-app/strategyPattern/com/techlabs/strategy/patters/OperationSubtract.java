package com.techlabs.strategy.patters;

public class OperationSubtract implements IStrategy{

	@Override
	public int doOperation(int num1, int num2) {
		return num1 - num2;
	}

}

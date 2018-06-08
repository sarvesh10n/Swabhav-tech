package com.techlabs.strategy.patters;

public class StrategyPatternTest {

	public static void main(String args[])
	{
		Context context=new Context(new OperationAdd());
		System.out.println(context.executeStrategy(2, 3));
		
	}
}

package com.techlabs.inheritance;

public class Boy extends Man{

	
	static{
		System.out.println("Inside boy static");
	}
	public Boy()
	{
		super();
		System.out.println("Boy created");
		
	}
	public void walk()
	{
		System.out.println("Boy is walking");
	}
	
	@Override
	public void play()
	{
		System.out.println("Boy is playing");
	}
}

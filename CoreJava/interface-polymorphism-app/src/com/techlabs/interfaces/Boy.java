package com.techlabs.interfaces;

public class Boy implements IMannerable,IEmotionalbe{
	
	@Override
	public void wish() {
		System.out.println("Boy says hello");
	}

	@Override
	public void depart() {
		System.out.println("Boy depart");
	}
	
	@Override
	public void cry()
	{
		System.out.println("Boy cries");
	}
	
	@Override
	public void laugh()
	{
		System.out.println("Boy laughs");
	}

}

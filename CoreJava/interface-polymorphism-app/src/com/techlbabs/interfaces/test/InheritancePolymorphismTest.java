package com.techlbabs.interfaces.test;
import com.techlabs.interfaces.*;

public class InheritancePolymorphismTest {
	
	public static void main(String args[])
	{
		Man x=new Man();
		Boy y=new Boy();
		
		atTheParty(x);
		atTheParty(y);
		
		atTheMovies(y);
		atTheMovies(y);
	}
	
	public static void atTheParty(IMannerable obj)
	{
		System.out.println("At the party");
		obj.wish();
		obj.depart();
	}
	
	public static void atTheMovies(IEmotionalbe obj)
	{
		System.out.println("At the movie");
		obj.cry();
		obj.laugh();
	}
}

package com.techlabs.inheritance.test;
import com.techlabs.inheritance.*;

public class TestInheritance {

	public static void main(String args[])
	{
		//System.out.println("case 1");
		//case1();
		System.out.println("case 2");
		case2();
		//System.out.println("case 3");
		//case3();
		//System.out.println("case 4");
		//case4();
	}
	
	public static void case1()
	{
		Man man;
		man=new Man();
		man.eat();
		man.play();
		man.read();
	}
	
	public static void case2()
	{
		Boy boy;
		boy=new Boy();
		boy.eat();
		boy.read();
		boy.walk();
		boy.play();
	}
	
	public static void case3()
	{
		Man man;
		man=new Boy();
		man.eat();
		man.play();
		man.read();
	}
	
	public static void case4()
	{
		atThePark(new Man());
		atThePark(new Boy());
		atThePark(new Kid());
		atThePark(new Infant());
	}
	
	public static void atThePark(Man man)
	{
		System.out.println("At the park");
		man.play();
		System.out.println();
	}
}

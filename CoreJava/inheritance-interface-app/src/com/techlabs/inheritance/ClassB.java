package com.techlabs.inheritance;
import com.techlabs.interfaces.*;

public class ClassB extends ClassA implements InterfaceA{

	public void classBMethod()
	{
		System.out.println("Class B method");
	}
	
	public void interfaceMethod()
	{
		System.out.println("Interface method");
	}
}

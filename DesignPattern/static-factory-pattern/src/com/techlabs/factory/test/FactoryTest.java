package com.techlabs.factory.test;
import com.techlabs.factory.AutoMobileFactory;
import com.techlabs.factory.AutoType;
import com.techlabs.interfaces.IAutomobile;

public class FactoryTest {

	public static void main(String args[])
	{
		IAutomobile auto1 = AutoMobileFactory.make(AutoType.BMW);
		System.out.println(auto1.getClass());
		
		IAutomobile auto2 = AutoMobileFactory.make(AutoType.AUDI);
		System.out.println(auto2.getClass());
		
		IAutomobile auto3 = AutoMobileFactory.make(AutoType.TESLA);
		System.out.println(auto3.getClass());
	}
}

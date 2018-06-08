package com.techlabs.factory.test;

import com.techlabs.factories.AudiFactory;
import com.techlabs.factories.BmwFactory;
import com.techlabs.interfaces.IAutomobileFactory;

public class FactoryTest {

	public static void main(String args[])
	{
		IAutomobileFactory automobileFactory= BmwFactory.getInstance();
		automobileFactory.makeSuv().start();
		
		IAutomobileFactory automobileFactory1= BmwFactory.getInstance();
		automobileFactory1.makeSuv().stop();
		
		IAutomobileFactory automobileFactory2= BmwFactory.getInstance();
		automobileFactory2.makeSedan().start();
	
		IAutomobileFactory automobileFactory3= BmwFactory.getInstance();
		automobileFactory3.makeSedan().stop();
		
		IAutomobileFactory automobileFactory4=BmwFactory.getInstance();
		automobileFactory4.makeHatchback().start();
	
		IAutomobileFactory automobileFactory5=BmwFactory.getInstance();
		automobileFactory5.makeHatchback().stop();
		
		IAutomobileFactory automobileFactory6=AudiFactory.getInstance();
		automobileFactory6.makeSuv().start();
	}
}

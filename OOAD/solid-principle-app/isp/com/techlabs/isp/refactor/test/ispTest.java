package com.techlabs.isp.refactor.test;

import com.techlabs.isp.refactor.IEatable;
import com.techlabs.isp.refactor.IWorkable;
import com.techlabs.isp.refactor.Manager;
import com.techlabs.isp.refactor.Robot;

public class ispTest {

	public static void main(String args[])
	{
		Manager manager=new Manager();
		Robot robot=new Robot();
		
		atTheWorkStation(manager);
		atTheWorkStation(robot);
		atTheCafeteria(manager);
	}

	private static void atTheWorkStation(IWorkable obj) {
		System.out.println("At the work");
		obj.startWork();
		obj.stopWork();
		
	}
	private static void atTheCafeteria(IEatable obj) {
		obj.startEat();
		obj.stopEat();
		
	}
}

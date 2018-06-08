package com.techlabs.isp.violation.test;

import com.techlabs.isp.violation.IWorker;
import com.techlabs.isp.violation.Manager;
import com.techlabs.isp.violation.Robot;

public class ispTest {

	public static void main(String args[])
	{
		Manager manager=new Manager();
		Robot robot=new Robot();
		
		atTheWorkStation(manager);
		atTheWorkStation(robot);
		
		atTheCafeteria(manager);
		atTheCafeteria(robot);
	}

	private static void atTheWorkStation(IWorker obj) {
		System.out.println("At the work");
		obj.startWork();
		obj.stopWork();
		
	}
	private static void atTheCafeteria(IWorker obj) {
		obj.startEat();
		obj.stopEat();
		
	}
}

package com.techlabs.data.service.test;

import com.techlabs.data.service.DataService;

public class DataServiceTest {

	public static void main(String args[])
	{
		DataService service1 =DataService.getInstance();
		DataService service2 =DataService.getInstance();
		
		service1.doWork();
		service2.doWork();
		
	}
}

package com.techlabs.data.service;

public class DataService {

	private static DataService service;

	private DataService() {
		System.out.println("Instance created");
	}

	public static DataService getInstance() {

		if (service == null)
			service = new DataService();

		return service;
	}

	public void doWork() {
		System.out.println("Service with " + service.hashCode()
				+ " is doing some work");
	}
}

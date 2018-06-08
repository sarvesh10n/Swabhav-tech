package com.techlabs.dip.refactor;

public class CsvLogger implements ILog {

	public void log(String message) {
		System.out.println("Writing csv log");
		System.out.println(message);
	}

}

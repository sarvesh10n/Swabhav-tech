package com.techlabs.dip.refactor;

public class XmlLogger implements ILog{

	public void log(String message) {
		System.out.println("Writing xml log");
		System.out.println(message);
	}

}

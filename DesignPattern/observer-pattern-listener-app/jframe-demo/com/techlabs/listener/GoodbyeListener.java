package com.techlabs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoodbyeListener implements ActionListener{

	public GoodbyeListener(){

	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Goodbye listener");
		
	}

}

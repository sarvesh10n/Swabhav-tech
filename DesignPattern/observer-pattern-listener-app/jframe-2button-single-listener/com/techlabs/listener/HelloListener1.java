package com.techlabs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloListener1 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getActionCommand());
		System.out.println("Hello Listener");
		
	}

}

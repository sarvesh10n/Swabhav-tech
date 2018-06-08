package com.techlabs.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.techlabs.listener.HelloListener1;

public class WelcomeFrame1 extends JFrame{
	
	public WelcomeFrame1() {
		setTitle("Welcome Frame");
		setVisible(true);
		setSize(1024, 708);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		add(panel);
		JButton button = new JButton("Button1");
		panel.add(button);
		
		JPanel panel2 = new JPanel();
		add(panel);
		JButton button2 = new JButton("Button2");
		panel.add(button2);

		button.addActionListener(new HelloListener1());
		
		button2.addActionListener(new HelloListener1());

	}

}

package com.techlabs.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.techlabs.listener.GoodbyeListener;
import com.techlabs.listener.HelloListener;

public class WelcomeFrame extends JFrame {

	public WelcomeFrame() {
		setTitle("Welcome Frame");
		setVisible(true);
		setSize(1024, 708);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		add(panel);
		JButton button = new JButton("Button");
		panel.add(button);

		button.addActionListener(new GoodbyeListener());
		button.addActionListener(new HelloListener());

	}

}

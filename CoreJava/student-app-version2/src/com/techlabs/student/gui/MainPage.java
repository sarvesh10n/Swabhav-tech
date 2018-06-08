package com.techlabs.student.gui;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import com.techlabs.student.tasks.Student;
import com.techlabs.student.tasks.StudentDataStore;

public class MainPage extends JFrame{
	
	JLabel displayStudents;

	public MainPage()
	{
		setTitle("Home page");
		setVisible(true);
		setSize(1024, 708);
		JPanel panel = new JPanel();
		add(panel);
		displayStudents=new JLabel();
		JButton displayStudent = new JButton("Display Students");
		panel.add(displayStudent);
		displayStudent.addActionListener(new DisplayDetailListener());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JLabel getDisplayStudents()
	{
		return displayStudents;
	}
	
public static void main(String args[])
{
	new MainPage();
}

}

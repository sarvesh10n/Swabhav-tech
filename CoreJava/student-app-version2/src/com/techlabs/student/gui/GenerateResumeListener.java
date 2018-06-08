package com.techlabs.student.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.techlabs.generate.resume.GenerateResumes;
import com.techlabs.student.tasks.Student;
import com.techlabs.student.tasks.StudentDataStore;

public class GenerateResumeListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new GenerateResumes().generateResumes();
		
	}
}

 class DisplayDetailListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Iterable<Student> list=new StudentDataStore().getList();
		MainPage mainPage=new MainPage();
		mainPage.getDisplayStudents().setText("Sarvesh");
	}
}

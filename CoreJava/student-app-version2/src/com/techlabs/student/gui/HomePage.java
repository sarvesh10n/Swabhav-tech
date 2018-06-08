package com.techlabs.student.gui;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.JTextField;

import com.techlabs.generate.resume.GenerateResumes;
import com.techlabs.student.tasks.Student;
import com.techlabs.student.tasks.StudentDataStore;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class HomePage {

	private JFrame frame;
	private JTextField txtStudentFirstname;
	private JTextField txtStudentLastname;
	private JTextField txtStudentAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		StudentDataStore studentDataStore = new StudentDataStore();

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblStudentApp = new JLabel("Student app");
		frame.getContentPane().add(lblStudentApp, BorderLayout.NORTH);

		JPanel panel_south = new JPanel();
		frame.getContentPane().add(panel_south, BorderLayout.SOUTH);
		panel_south.setLayout(new GridLayout(4, 1));

		


		txtStudentFirstname = new JTextField();
		txtStudentFirstname.setText("Student FirstName");
		panel_south.add(txtStudentFirstname);
		txtStudentFirstname.setColumns(10);

		txtStudentLastname = new JTextField();
		txtStudentLastname.setText("Student LastName");
		panel_south.add(txtStudentLastname);
		txtStudentLastname.setColumns(10);

		txtStudentAddress = new JTextField();
		txtStudentAddress.setText("Student Address");
		panel_south.add(txtStudentAddress);
		txtStudentAddress.setColumns(10);

		JPanel panel = new JPanel();
		panel_south.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnDisplayDetails = new JButton("Display Details");
		btnDisplayDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final ArrayList<String> studentDetails = new ArrayList<String>();
				Iterable<Student> student_list = studentDataStore.getList();
				String details = "RollNO\t\t\t\t\t\tName\tAddress\t\t\t\n";
				for (Student student : student_list) {
					studentDetails.add(details);
					details = student.getRollNo() + "\t"
							+ student.getFirstName() + " "
							+ student.getLastName() + "\t"
							+ student.getAddress() + "\n";
					
				}
				JList<String> displayList = new JList<>(studentDetails.toArray(new String[0]));
				JScrollPane scrollPane = new JScrollPane(displayList);
				frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
			}
		});
		panel.add(btnDisplayDetails);

		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = txtStudentFirstname.getText();
				String lastName = txtStudentLastname.getText();
				String address = txtStudentAddress.getText();

				Student student = new Student();
				student.setFirstName(firstName);
				student.setLastName(lastName);
				student.setAddress(address);
				studentDataStore.addStudent(student);

				txtStudentFirstname.setText("");
				txtStudentLastname.setText("");
				txtStudentAddress.setText("");
			}
		});
		panel.add(btnAddEmployee);

		JButton btnGenerateReseume = new JButton("Generate Resume");
		btnGenerateReseume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GenerateResumes().generateResumes();
			}
		});
		panel.add(btnGenerateReseume);

	}

}

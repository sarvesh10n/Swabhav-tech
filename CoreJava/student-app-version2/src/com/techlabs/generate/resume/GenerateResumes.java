package com.techlabs.generate.resume;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import com.techlabs.student.tasks.Student;
import com.techlabs.student.tasks.StudentDataStore;

public class GenerateResumes {


	private String name;
	private String address;
	private UUID rollNo;
	public void generateResumes()
	{	
		ArrayList<Student> studentList=	new StudentDataStore().getList();
		for (Student student :studentList) {
			name=student.getFirstName()+" "+student.getLastName();
			address=student.getAddress();
			rollNo=student.getRollNo();
			createResumes();
		}
	}
	
	public void createResumes() {
		try {
			FileReader reader = new FileReader("Data/Resume_Templates/srt-resume.html");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line,fileContent="";

			while ((line = bufferedReader.readLine()) != null) {
				fileContent=fileContent+line+"\n";
			}
			
			fileContent = fileContent.replace("$name", name);
			fileContent = fileContent.replace("$address", address);
			fileContent = fileContent.replace("$roll_no",""+rollNo);
			FileWriter fw=new FileWriter("Data/Resumes/"+rollNo+" Resume.html");
			fw.write(fileContent);
			fw.close();
			reader.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

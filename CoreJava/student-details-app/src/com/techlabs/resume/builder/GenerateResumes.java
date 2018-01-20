package com.techlabs.resume.builder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.techlabs.student.Student;
import com.techlabs.student.functions.StudentList;

public class GenerateResumes {


	private String name;
	private String address;
	public void generateResumes()
	{	
		for (Student student : StudentList.studentList) {
			name=student.getFirstName()+" "+student.getLastName();
			address=student.getAddress();
			createResume();
		}
	}
	
	public void createResume() {
		try {
			FileReader reader = new FileReader("Data/Resume_Templates/srt-resume.html");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line,fileContent="";

			while ((line = bufferedReader.readLine()) != null) {
				fileContent=fileContent+line+"\n";
			}
			
			fileContent = fileContent.replace("$name", name);
			fileContent = fileContent.replace("$address", address);
			FileWriter fw=new FileWriter("Data/Resumes/"+name+"Resume.html");
			fw.write(fileContent);
			fw.close();
			reader.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

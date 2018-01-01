package com.techlabs.resume.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Object;

import org.apache.commons.io.FileUtils;

public class ResumeBuilder {

	private String name;
	private String contact;
	private String hobby;
	private String qualification;

	public ResumeBuilder(String name,String contact,String hobby,String qualification) {
		this.name=name;
		this.contact=contact;
		this.hobby=hobby;
		this.qualification=qualification;
	}

	public void createResume() {
		try {
			FileReader reader = new FileReader("srt-resume.html");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line,fileContent="";

			while ((line = bufferedReader.readLine()) != null) {
				fileContent=fileContent+line+"\n";
			}
			
			fileContent = fileContent.replace("$name", name);
			fileContent = fileContent.replace("$contact", contact);
			fileContent = fileContent.replace("$hobby", hobby);
			fileContent = fileContent.replace("$qualification", qualification);
			FileWriter fw=new FileWriter("resume.html");
			fw.write(fileContent);
			fw.close();
			reader.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

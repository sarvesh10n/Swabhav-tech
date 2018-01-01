package com.techlabs.file.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.techlabs.file.read.DataFileReader;
import com.techlabs.file.write.DataFileWriter;

public class FileReadingWritingTest {

	public static void main(String args[]) {

		DataFileReader read = new DataFileReader();
		read.readFile("file.txt");
		
		DataFileWriter write= new DataFileWriter();
		write.writeFile("myFile.txt");
	}
}

package com.techlabs.file.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.techlabs.file.read.FileRead;
import com.techlabs.file.write.FileWrite;

public class FileReadingWritingTest {

	public static void main(String args[]) {

		FileRead read = new FileRead();
		read.readFile("file.txt");
		
		FileWrite write= new FileWrite();
		write.writeFile("myFile.txt");
	}
}

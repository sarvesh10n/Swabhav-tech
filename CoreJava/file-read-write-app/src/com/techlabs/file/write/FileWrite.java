package com.techlabs.file.write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

	public void writeFile(String fileName) {
		try {

			FileWriter writer = new FileWriter(fileName,true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);

			bufferedWriter.write("Hiiii !!!");
            bufferedWriter.newLine();
            bufferedWriter.write("File written succesfully");
 
            bufferedWriter.close();

		} catch (IOException e) {
			System.out.println("file not found");
		}
	}
}

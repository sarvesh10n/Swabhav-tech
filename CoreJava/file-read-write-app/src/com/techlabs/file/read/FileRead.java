package com.techlabs.file.read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

	public void readFile(String fileName)
	{
		try {

			FileReader reader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();

		} catch (IOException e) {
			System.out.println("file not found");
		}
	}
}

package com.techlabs.loader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileLoader implements ILoadable {

	private String data = "";

	@Override
	public String loadFile() throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(
				"Data/dataFile.txt"));

		String line = reader.readLine();

		while (line != null) {
			data += line + "\n";
			line = reader.readLine();
		}
		reader.close();
		return data;

	}

}

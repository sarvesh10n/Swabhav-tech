package com.techlabs.property.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyFileTest {

	public static void main(String args[])
	{
		generatePropertyFile();
		
		
		fetchPropertyFile();

	}

	private static void fetchPropertyFile() {
		Properties properties = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");
			properties.load(input);
			
			System.out.println(properties.getProperty("database"));
			System.out.println(properties.getProperty("dbuser"));
			System.out.println(properties.getProperty("dbpassword"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void generatePropertyFile() {
		Properties properties = new Properties();
		OutputStream output = null;
		
		try {

			output = new FileOutputStream("config.properties");
			properties.setProperty("database", "localhost");
			properties.setProperty("dbuser", "sarvesh");
			properties.setProperty("dbpassword", "password");
			properties.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}

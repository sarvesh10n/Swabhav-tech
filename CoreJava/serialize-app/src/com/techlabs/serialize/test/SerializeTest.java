package com.techlabs.serialize.test;

import com.techlabs.serialize.*;

import java.io.*;

public class SerializeTest {

	public static void main(String args[]) {
		Rectangle rect = new Rectangle();
		rect.setHeight(30);
		rect.setWidth(50);

		try {
			FileOutputStream fs = new FileOutputStream("rectFile.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(rect);
			os.close();
			
			FileInputStream is=new FileInputStream("rectFile.ser");
			ObjectInputStream ois=new ObjectInputStream(is);
			Rectangle rectDeserialized	=(Rectangle)ois.readObject();
			
			System.out.println(rectDeserialized.getHeight());
			System.out.println(rectDeserialized.getWidth());
		} catch (Exception e) {
		}
	}

}

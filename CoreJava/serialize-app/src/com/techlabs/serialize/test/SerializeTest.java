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
		} catch (Exception e) {
		}
	}

}

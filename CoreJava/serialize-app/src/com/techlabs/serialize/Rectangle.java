package com.techlabs.serialize;

import java.io.Serializable;

public class Rectangle implements Serializable {

	private int width;
	private int height;

	public void setWidth(int pWidth) {
		width = pWidth;
	}

	public void setHeight(int pHeight) {
		height = pHeight;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int calculateArea() {
		return width * height;
	}
}

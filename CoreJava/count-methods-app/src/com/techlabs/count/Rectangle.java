package com.techlabs.count;

public class Rectangle {

	private int width;
	private int height;
	private String bColor;

	private int validateSide(int side) {
		if (side < 0)
			return 1;
		if (side > 100)
			return 100;
		else
			return side;
	}

	public void setWidth(int pWidth) {
		width = validateSide(pWidth);
	}
	
	
	@NeedRefactorLater
	 
	public void setHeight(int pHeight) {
		height = validateSide(pHeight);
	}
	@NeedRefactorLater
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public String validateColor(String borderColor) {
		if (borderColor.equalsIgnoreCase("red")
				|| borderColor.equalsIgnoreCase("green")
				|| borderColor.equalsIgnoreCase("blue"))
			return borderColor;
		else
			return "red";
	}

	public void setBorderColor(String borderColor) {

		bColor = validateColor(borderColor);

	}

	public String getBorderColor() {
		return bColor;
	}

	public int calculateArea() {
		return width * height;
	}
}

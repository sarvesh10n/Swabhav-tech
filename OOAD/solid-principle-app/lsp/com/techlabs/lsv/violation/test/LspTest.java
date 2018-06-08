package com.techlabs.lsv.violation.test;

import com.techlabs.lsv.violation.Rectangle;
import com.techlabs.lsv.violation.Square;

public class LspTest {

	public static void main(String args[])
	{
		Rectangle rect=new Rectangle(10, 12);
		shouldNotChangeWidthIfHeightChanged(rect);
		
		Square square=new Square(10);
		shouldNotChangeWidthIfHeightChanged(square);
	}
	
	public static void shouldNotChangeWidthIfHeightChanged(Rectangle rect)
	{
		int beforeWidth=rect.getWidth();
		rect.setHeight(20);
		int afterWidth=rect.getWidth();
		System.out.println("Before width "+beforeWidth);
		System.out.println("After width "+afterWidth);
	}
}

package com.techlabs.lsv.refactor.test;

import com.techlabs.lsv.refactor.Rectangle;

public class LspTest {

	public static void main(String args[])
	{
		Rectangle rect=new Rectangle(10, 12);
		shouldNotChangeWidthIfHeightChanged(rect);		
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

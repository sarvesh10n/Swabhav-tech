package com.techlabs.shape.maker.test;
import com.techlabs.shape.maker.*;

public class FacadePatternTest {

	 public static void main(String[] args) {
	      ShapeMaker shapeMaker = new ShapeMaker();

	      shapeMaker.drawCircle();
	      shapeMaker.drawRectangle();
	      shapeMaker.drawSquare();		
	   }
}

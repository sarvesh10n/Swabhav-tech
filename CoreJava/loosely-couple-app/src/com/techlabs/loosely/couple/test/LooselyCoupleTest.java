package com.techlabs.loosely.couple.test;
import com.techlabs.interfaces.*;
import com.techlabs.classes.*;

public class LooselyCoupleTest {

	public static void main(String args[])
	{
		Topic t=new Topic1();
		t.understand();
		t=new Topic2();
		t.understand();
	}
}

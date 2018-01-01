package com.techlabs.custom.exception.test;
import com.techlabs.custom.exception.*;

public class CustomExceptionTest {

	static void validate(int age){
		if (age < 18)
			throw new InvalidAgeException("not valid");
		else
			System.out.println("welcome to vote");
	}

	public static void main(String args[]) {
		
			validate(13);
		

	}
}

package com.techlabs.custom.exception.test;
import com.techlabs.custom.exception.*;

public class CustomExceptionTest {

	static void validate(int age) throws InvalidAgeException {
		if (age < 18)
			throw new InvalidAgeException("not valid");
		else
			System.out.println("welcome to vote");
	}

	public static void main(String args[]) {
		try {
			validate(13);
		} catch (Exception m) {
			System.out.println("Exception occured: " + m);
		}

	}
}
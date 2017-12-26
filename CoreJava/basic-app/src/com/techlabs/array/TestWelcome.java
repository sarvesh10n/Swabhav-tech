package com.techlabs.array;

public class TestWelcome {

	public static void main(String names[]) {

		if (names.length == 0)
			System.out.println("Pass some names");
		else
			for(String i:names)
				System.out.println(i);
	}
}

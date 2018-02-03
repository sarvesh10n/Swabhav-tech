package com.techlabs.collection.test;

import java.util.ArrayList;
import java.util.Iterator;

import com.techlabs.collection.LineItem;

public class TestLineGenericCollection {

	public static void main(String args[]) {
		ArrayList<LineItem> cart = new ArrayList<LineItem>();
		cart.add(new LineItem(1, "milk", 2, 20.0));
		cart.add(new LineItem(6, "paste", 1, 50.0));
		cart.add(new LineItem(5, "biscuit", 5, 10.0));

		printUsingIterator(cart);
		printUsingIterable(cart);

	}

	private static void printUsingIterator(ArrayList<LineItem> cart) {
		Iterator<LineItem> i = cart.iterator();
		while (i.hasNext()) {
			LineItem item = i.next();
			System.out.println();
			System.out.println("Id is " + item.getId());
			System.out.println("Name is " + item.getName());
			System.out.println("Price is " + item.calcTotalCost());
		}
	}

	public static void printUsingIterable(Iterable<LineItem> cart) {
		for(LineItem x:cart)
		{
			System.out.println();
			System.out.println("Id is " + x.getId());
			System.out.println("Name is " + x.getName());
			System.out.println("Price is " + x.calcTotalCost());
		}
	}

}

package com.collections.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.techlabs.collection.LineItem;

public class TestLineItemSort {

	public static void main(String args[]) {
		ArrayList<LineItem> cart = new ArrayList<LineItem>();
		cart.add(new LineItem(1, "milk", 2, 20.0));
		cart.add(new LineItem(6, "paste", 1, 50.0));
		cart.add(new LineItem(5, "biscuit", 5, 10.0));

		printUsingIterable(cart);
		Collections.sort(cart,new SortByNameComparator());
		printUsingIterable(cart);
	}

	public static void printUsingIterable(Iterable<LineItem> cart) {
		for (LineItem x : cart) {
			System.out.println();
			System.out.println("Id is " + x.getId());
			System.out.println("Name is " + x.getName());
			System.out.println("Price is " + x.calcTotalCost());
		}
	}
}

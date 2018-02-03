package com.techlabs.collection.test;

import com.techlabs.collection.*;

import java.util.ArrayList;
import java.util.Iterator;

public class TestLineItemCollection {

	public static void main(String args[]) {
		ArrayList cart = new ArrayList();
		cart.add(new LineItem(1, "milk",2 ,20.0));
		cart.add(new LineItem(6, "paste",1 ,50.0));
		cart.add(new LineItem(7, "biscuit",5 ,10.0));
		
		
		Iterator i= cart.iterator();
		while(i.hasNext())
		{
			LineItem item=(LineItem)i.next();
			System.out.println("Id is "+item.getId());
			System.out.println("Name is "+item.getName());
			System.out.println("Price is "+item.calcTotalCost());
		}
		
		
	}

}

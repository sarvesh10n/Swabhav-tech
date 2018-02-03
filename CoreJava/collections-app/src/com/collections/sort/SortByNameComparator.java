package com.collections.sort;

import java.util.Comparator;

import com.techlabs.collection.LineItem;

public class SortByNameComparator implements Comparator<LineItem>{

	@Override
	public int compare(LineItem arg0, LineItem arg1) {
		String name1= arg0.getName();
		String name2=arg1.getName();
		return name1.compareTo(name2);
	}

	
}

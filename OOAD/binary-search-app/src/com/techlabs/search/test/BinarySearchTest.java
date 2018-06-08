package com.techlabs.search.test;

import com.techlabs.search.BinarySearch;
import com.techlabs.sort.MergeSort;

public class BinarySearchTest {

	public static void main(String args[])
	{
		int numbers[]=new int[]{2,3,4,5,1};
		BinarySearch binarySearch=new BinarySearch(numbers, new MergeSort(),3);
		int position=binarySearch.binarySearch(0, numbers.length-1);
		System.out.println("Given key is at "+(position+1)+" position");
	}
}

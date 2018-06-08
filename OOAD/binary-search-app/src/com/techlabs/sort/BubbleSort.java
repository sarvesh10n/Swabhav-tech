package com.techlabs.sort;

public class BubbleSort implements ISortable{

	
	int numbers[];
	@Override
	public int[] sortArray(int[] numbers) {
		this.numbers=numbers;
		bubbleSort();
		return null;
	}
	private void bubbleSort() {
		int i, j,temp;
		   for (i = 0; i < numbers.length-1; i++)      
		 
		       // Last i elements are already in place   
		       for (j = i+1; j < numbers.length; j++) 
		           if (numbers[j] > numbers[j+1])
		           {
		        	   temp=numbers[j+1];
		        	   numbers[j+1]=numbers[j];
		        	   numbers[j]=temp;
		        	   
		           }
	}

}

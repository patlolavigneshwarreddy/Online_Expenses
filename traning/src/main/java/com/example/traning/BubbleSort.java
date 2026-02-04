package com.example.traning;

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] values = {9,1,2,3,5,3,4,5,5,7,8,9,9,10,6};
		
	int temp= 0;
	
	for(int i = 0; i<values.length ; i++) {
		
		for(int j =i+1 ;j<values.length ; j++) {
			
			if(values[i]<values[j]) {
				temp = values[i];
				values[i] = values[j];
				values[j] = temp;
			}
		}
		
	}
	System.out.println("1stH: "+ values[0]+", 2ndH"+values[1]);
}
	}

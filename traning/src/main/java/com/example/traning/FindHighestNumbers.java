package com.example.traning;

import java.text.Collator;
import java.util.Arrays;import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindHighestNumbers {

	public static void main(String[] args) {
	
	int[] values = {9,1,2,3,5,3,4,5,5,7,8,9,9,10,6};
	
	// find highest, 2nd highest, 3rd highest, 4 highest
	
	int firstH = 0, secondH=0, ThirdH=0, fourthH= 0 ;
	
	for (int i=0; i < values.length ; i++) {
	
		for(int j=i+1; j<values.length;j++) {
/*	if(values[i]>firstH) {
		fourthH = ThirdH;
		ThirdH = secondH;
		secondH = firstH;
		firstH = values[i];
	}*/ 
		if (values[i]<values[j]) {
			int temp = values[i];
		  values[i] = values[j];
		  values[j] = temp;
		}
		
		}
	}
	
	
	System.out.println("fourthH: "+fourthH+", ThirdH: "+ ThirdH+",secondH: "+secondH +",firstH :"+firstH);
	
	
	
	// find duplicate values
	
	
	Map<Integer, Long> result = Arrays.stream(values).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	
	result.forEach((t, u) -> {
		if(u>1) {
			System.out.println(t);
		}
		
	});
	
	Arrays.stream(values).boxed().sorted().distinct().forEach(a->System.out.println(a));
	
	
	//find max value
	List<Integer> listint = List.of(1,2,3,4,5,6);
	
	Optional<Integer> maxvalue =  listint.stream().max(Comparator.comparingInt(Integer::intValue));
	System.out.println("find max value");
	maxvalue.ifPresent(System.out::println);
	
	//find min value
		
		Optional<Integer> minvalue =  listint.stream().min(Comparator.comparingInt(Integer::intValue));
		System.out.println("find min value");
		minvalue.ifPresent(System.out::println);
	
		// find avg value 
		OptionalDouble avgvalue = listint.stream().mapToInt(Integer::intValue).average();
		System.out.println("find avg value");
		avgvalue.ifPresent(System.out::println);	
	}
	
	
	
	
	
	
}

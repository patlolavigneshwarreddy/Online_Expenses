package com.example.traning;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import ch.qos.logback.core.net.SyslogOutputStream;

public class FunctionalInterfacePreDefineFunctions {

	
	public static void main (String[] args) {
		
		// predicate function
		
		Predicate<Integer> predicateResult = s -> s % 2 == 0;
		System.out.println(predicateResult.test(1));
	
	   // consumer will accept only value not return
		Consumer<String> consumerResult = s ->System.out.println(s);
		consumerResult.accept("Hello this is consumer");
	
	  // supplier will return value but not accept values
		Supplier<String> supplierresult = ()->"supplier return value not accept values";
	     System.out.println(supplierresult.get());
	
	     Function<String, Integer> functionresult = s->s.length();
	     System.out.println(functionresult.apply("hello"));
	}
	
}

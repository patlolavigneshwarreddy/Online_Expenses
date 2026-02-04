package com.example.traning;


public class Human {

    public static void main(String[] args) {
   
        Object obj = "Hello world";
// 2 feature of .... Pattern Matching for instanceof 
        if(obj instanceof String s) {
        	System.out.println("Pattern Matching for instanceof string  :"+ s);
        	}
        	 else if (obj instanceof Integer i) {
                 System.out.println("Pattern Matching for instanceof Integer: " + i);
             } else {
                 System.out.println("Pattern Matching for instanceof Unknown type");
             }
//3 feature .............Pattern Matching for Switch
        Object obj1 = 1;
    switch(obj1) {
    case String s -> System.out.println("Pattern Matching for Switch String value : "+obj1);
    case Integer i -> System.out.println("Pattern Matching for Switch Integer value : "+obj1);
	default-> System.out.println("Pattern Matching for Switch Unknown type");
    }
    
//4 feature .............Pattern Matching for Switch expressions
    Object obj2 = 2;
    int result = switch (obj2) {
        case String s -> s.length();
        case Integer i -> i * 2;
        default -> 0;
    };
    System.out.println("Pattern Matching for Switch expressions: "+result);

// 5 feature............text block        
    
    String html = """
    	            <title>Hello This is tex block java 17 feature write multi line</title>
    	            
    	    
    	            <h1>Hello, World!</h1>
    
    	    """;
    	System.out.println(html);
    }

}




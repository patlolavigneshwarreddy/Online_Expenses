package com.example.traning;

import java.util.ArrayList;import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindEmployeeCountOnEachDept {

public static void main(String[] args) {
	List<Employe> emplist =  new ArrayList<>();
	emplist.add(new Employe(1, "vicky", 100000, "IT", "hyderabad"));
	emplist.add(new Employe(2, "viplove", 200000, "IT", "ban"));
	emplist.add(new Employe(3, "vigneshwar", 100000, "NONIT", "hyderabad"));
	emplist.add(new Employe(4, "patlola", 300000, "HR", "chenni"));
	emplist.add(new Employe(5, "reddy", 500000, "HR", "ban"));


/* find list of department head count */

Map<String,List<Employe>> eachDepartemployes = emplist.stream().collect(Collectors.groupingBy(Employe::getDepartment));
System.out.println("find list of department head count");
eachDepartemployes.forEach((t, u) ->
System.out.println(t+"=: "+u)
		);

/* find 1st and 3rd highest salary persons */
System.out.println("find 1st and 3rd highest salary persons");

Optional<Employe> firstHemploye = emplist.stream().max(Comparator.comparingDouble(Employe::getSalary)); 
System.out.println("firstHighestSalaryEMP: "+firstHemploye);

Optional<Employe> ThirdHemploye = emplist.stream().distinct().sorted(Comparator.comparingDouble(Employe::getSalary)).skip(2).findFirst(); 
System.out.println("firstHighestSalaryEMP: "+ThirdHemploye);


/* change all employes first char to capital */
List<Employe> employes = emplist.stream().peek(e -> e.setName(e.getName().substring(0, 1).toUpperCase()+e.getName().substring(1))).toList();
System.out.println("change all employes first char to capital");
System.out.println(employes);



}
}
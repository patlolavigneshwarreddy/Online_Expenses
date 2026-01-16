package com.example.expenses_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expenses_server.controller.service.ExpensesService;
import com.example.expenses_server.entity.Expenses;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {

	@Autowired
	ExpensesService expensesService;
	
	@PostMapping()
	public ResponseEntity<Expenses> addexpenses(@RequestHeader("X-User-Id") Long userId, @RequestBody Expenses expenses) {
	expensesService.addexpenses(expenses);
		return new ResponseEntity<Expenses>(expenses, HttpStatus.CREATED);
	}
	
	
	@PutMapping()
	public String editexpenses() {
	//implement your code
		return "edit expenses";
	}
	
	 @PutMapping("/{id}")
	    public ResponseEntity<Expenses> updateExpense(
	    		@RequestHeader("X-User-Id") Long userId,
	            @PathVariable Long id,
	            @RequestBody Expenses updatedExpense) {

	        Expenses expense = expensesService.updateExpense(id, updatedExpense);
	        return ResponseEntity.ok(expense);
	    }
	
	@GetMapping("/{id}")
	public String getbyIdexpenses(@RequestHeader("X-User-Id") Long userId) {
	//implement your code
		return "get byt id expenses";
	}
	
	@GetMapping
	public String getexpenses() {
	//implement your code
		return "get all expenses";
	}
	
	@DeleteMapping
	public String deleteexpensesById() {
	//implement your code
		return "delete expenses by Id";
	}	
	
}

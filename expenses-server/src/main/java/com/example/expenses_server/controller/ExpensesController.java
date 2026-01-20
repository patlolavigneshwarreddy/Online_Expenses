package com.example.expenses_server.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.expenses_server.controller.record.MonthlyCategorySummary;
import com.example.expenses_server.controller.record.MonthlySummary;
import com.example.expenses_server.controller.service.ExpensesService;
import com.example.expenses_server.controller.service.ReportSummeryService;
import com.example.expenses_server.dto.CategoryDto;
import com.example.expenses_server.entity.Expenses;
import com.example.expenses_server.exceptions.ResourceNotFoundException;
import com.example.expenses_server.feignClient.CategoryClient;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {

	@Autowired
	ExpensesService expensesService;
	
	@Autowired
	ReportSummeryService reportsummery;
	
	@Autowired
	CategoryClient categoryClient;

	@PostMapping()
	public ResponseEntity<Expenses> addexpenses(@RequestHeader("X-User-Id") Long userId,
			@RequestBody Expenses expenses) {
		expensesService.addexpenses(expenses);
		return new ResponseEntity<Expenses>(expenses, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Expenses> updateExpense(@RequestHeader("X-User-Id") Long userId, @PathVariable Long id,
			@RequestBody Expenses updatedExpense) {

		Expenses expense = expensesService.updateExpense(id, updatedExpense);
		return ResponseEntity.ok(expense);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Expenses> getbyId(@RequestHeader("X-User-Id") Long userId, @PathVariable Long id) {
		Expenses expenses = expensesService.findbyId(id);
		return ResponseEntity.ok(expenses);
	}

	@GetMapping
	public ResponseEntity<List<Expenses>> getAllExpenses(@RequestHeader("X-User-Id") Long userId) {
		List<Expenses> expenses = expensesService.findbyUserId(userId);
		return ResponseEntity.ok(expenses);
	}

	@GetMapping(value = "category/{categoryId}")
	public ResponseEntity<List<Expenses>> getAllExpensesbyCategory(@RequestHeader("X-User-Id") Long userId,
			@PathVariable Long categoryId) {
		List<Expenses> expenses = expensesService.getAllExpensesbyCategory(userId, categoryId);
		return ResponseEntity.ok(expenses);
	}

	@GetMapping(value = "amount-range")
	public ResponseEntity<List<Expenses>> getAllExpensesbyAmountRange(@RequestHeader("X-User-Id") Long userId,
			@RequestParam("minAmount") BigDecimal minAmount, @RequestParam("maxAmount") BigDecimal maxAmount) {
		List<Expenses> expenses = expensesService.getAllExpensesbyAmountRange(userId, minAmount, maxAmount);
		return ResponseEntity.ok(expenses);
	}

	@GetMapping(value = "date-range")
	public ResponseEntity<List<Expenses>> getAllExpensesbyDateRange(@RequestHeader("X-User-Id") Long userId,
			@RequestParam("startDate") LocalDateTime startDate,
			@RequestParam("endDate") LocalDateTime endDate) {
		List<Expenses> expenses = expensesService.getAllExpensesbyDateRange(userId, startDate, endDate);
		return ResponseEntity.ok(expenses);
	}

	@DeleteMapping
	public ResponseEntity<String> deletebyId(@RequestHeader("X-User-Id") Long userId, @PathVariable Long id) {
		expensesService.deletebyId(id);
		return ResponseEntity.ok("delete expenses by Id");
	}
	
	    @GetMapping("/monthly")
	    public ResponseEntity<List<MonthlySummary>> getMonthlySummary(
	            @RequestHeader("X-User-Id") Long userId) {
	        List<MonthlySummary> summaries = reportsummery.getMonthlySummary(userId);
	        return ResponseEntity.ok(summaries);
	    }

	    @GetMapping("/monthlycategory")
	    public ResponseEntity<List<MonthlyCategorySummary>> getMonthlyCategorySummary(
	            @RequestHeader("X-User-Id") Long userId) {
	        List<MonthlyCategorySummary> summaries = reportsummery.getMonthlyCategorySummary(userId);
	        return ResponseEntity.ok(summaries);
	    }

	    @GetMapping("category/name/{id}")
		public ResponseEntity<CategoryDto> getCategoryNameById(@PathVariable Long id){
		CategoryDto category =	categoryClient.getCategoryById(id);
		if (category.getCategoryId() == -1L) {
	        return ResponseEntity
	                .status(HttpStatus.SERVICE_UNAVAILABLE)
	                .body(category);
	    }
			return new ResponseEntity<CategoryDto>(category, HttpStatus.OK);
			
		}

}

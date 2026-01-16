package com.example.expenses_server.controller.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.expenses_server.entity.Expenses;

@Service
public interface ExpensesService {

	void addexpenses(Expenses expenses);

	Expenses updateExpense(Long id, Expenses updatedExpense);

	Expenses findbyId(Long id);

	void deletebyId(Long id);

	List<Expenses> findbyUserId(Long userId);

	List<Expenses> getAllExpensesbyCategory(Long userId, Long categoryId);

	List<Expenses> getAllExpensesbyAmountRange(Long userId, BigDecimal minAmount, BigDecimal maxAmount);

	List<Expenses> getAllExpensesbyDateRange(Long userId, LocalDateTime startDate, LocalDateTime endDate);

}

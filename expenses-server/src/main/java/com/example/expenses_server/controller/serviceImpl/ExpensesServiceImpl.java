package com.example.expenses_server.controller.serviceImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expenses_server.controller.repo.ExpensesRepo;
import com.example.expenses_server.controller.service.ExpensesService;
import com.example.expenses_server.entity.Expenses;
import com.example.expenses_server.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ExpensesServiceImpl implements ExpensesService {

	@Autowired
	ExpensesRepo expensesRepo;

	@Override
	public void addexpenses(Expenses expenses) {
		expensesRepo.save(expenses);
	}

	@Transactional
	@Override
	public Expenses updateExpense(Long id, Expenses updatedExpense) {
		Expenses existing = expensesRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Expense not found with id " + id));

		// Update only allowed fields
		if (updatedExpense.getUserId() != null) {
			existing.setUserId(updatedExpense.getUserId());
		}
		if (updatedExpense.getCategoryId() != null) {
			existing.setCategoryId(updatedExpense.getCategoryId());
		}
		if (updatedExpense.getDebitamount() != 0) {
			existing.setDebitamount(updatedExpense.getDebitamount());
		}
		if (updatedExpense.getDescription() != null) {
			existing.setDescription(updatedExpense.getDescription());
		}

		// Save will automatically update `updatetime` because of @UpdateTimestamp
		return expensesRepo.save(existing);
	}

	@Override
	public Expenses findbyId(Long id) {
		Expenses existing = expensesRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Expense not found with id " + id));
		return existing;
	}

	@Override
	public void deletebyId(Long id) {
		expensesRepo.deleteById(id);
	}

	@Override
	public List<Expenses> findbyUserId(Long userId) {
		List<Expenses> expenses = expensesRepo.findByUserId(userId);
		return expenses;
	}

	@Override
	public List<Expenses> getAllExpensesbyCategory(Long userId, Long categoryId) {
		List<Expenses> expenses = expensesRepo.getAllExpensesbyCategory(userId,categoryId);
		return expenses;
	}

	@Override
	public List<Expenses> getAllExpensesbyAmountRange(Long userId, BigDecimal minAmount, BigDecimal maxAmount) {
		List<Expenses> expenses = expensesRepo.getAllExpensesbyAmountRange(userId,minAmount,maxAmount);
		return expenses;
	}

	@Override
	public List<Expenses> getAllExpensesbyDateRange(Long userId, LocalDateTime startDate, LocalDateTime endDate) {
		List<Expenses> expenses = expensesRepo.getAllExpensesbyDateRange(userId,startDate,endDate);
		return expenses;
	}

}

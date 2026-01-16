package com.example.expenses_server.controller.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expenses_server.controller.repo.ExpensesRepo;
import com.example.expenses_server.controller.service.ExpensesService;
import com.example.expenses_server.entity.Expenses;

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

}

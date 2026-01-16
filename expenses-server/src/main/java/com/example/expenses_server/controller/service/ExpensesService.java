package com.example.expenses_server.controller.service;

import com.example.expenses_server.entity.Expenses;

public interface ExpensesService {

	void addexpenses(Expenses expenses);

	Expenses updateExpense(Long id, Expenses updatedExpense);

}

package com.example.expenses_server.controller.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expenses_server.entity.Expenses;

public interface ExpensesRepo extends JpaRepository<Expenses, Long>{

	
}

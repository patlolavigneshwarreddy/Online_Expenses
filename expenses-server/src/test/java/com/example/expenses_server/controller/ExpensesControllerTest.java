package com.example.expenses_server.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.example.expenses_server.controller.service.ExpensesService;
import com.example.expenses_server.entity.Expenses;

@ExtendWith(MockitoExtension.class)
public class ExpensesControllerTest {

	@Mock
	ExpensesController expensesController;
	
	@InjectMocks
	ExpensesService expensesService;
	
	 @BeforeEach
	    void setUp() {
	        // MockitoExtension takes care of init
	    }
	 
	 @Test
	 void  addexpenses() {
		 
	 }
	
}

package com.example.expenses_server.controller.record;

public record MonthlySummary(
	int year,
    int month,
    Double totalAmount,
    long expenseCount
) {}

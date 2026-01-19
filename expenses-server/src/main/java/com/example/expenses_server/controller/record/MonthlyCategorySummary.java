package com.example.expenses_server.controller.record;


public record MonthlyCategorySummary(
        int year,
        int month,
        String categoryname,
        Double totalAmount,
        long expenseCount
) {}


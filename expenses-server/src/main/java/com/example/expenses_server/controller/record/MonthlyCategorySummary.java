package com.example.expenses_server.controller.record;

import java.math.BigDecimal;

public record MonthlyCategorySummary(
        int year,
        int month,
        Long categoryId,
        Double totalAmount,
        long expenseCount
) {}


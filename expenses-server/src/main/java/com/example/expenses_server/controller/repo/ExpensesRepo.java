package com.example.expenses_server.controller.repo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.expenses_server.entity.Expenses;

public interface ExpensesRepo extends JpaRepository<Expenses, Long> {

	@Query(value = "SELECT * FROM expenses WHERE user_id = :userId", nativeQuery = true)
	List<Expenses> findByUserId(@Param("userId") Long userId);

	@Query(value = "SELECT * FROM expenses WHERE user_id = :userId AND category_id = :categoryId", nativeQuery = true)
	List<Expenses> getAllExpensesbyCategory(@Param("userId") Long userId, @Param("categoryId") Long categoryId);

	@Query(value = """
			SELECT *
			FROM expenses
			WHERE user_id = :userId
			  AND debitamount BETWEEN :minAmount AND :maxAmount
			""", nativeQuery = true)
	List<Expenses> getAllExpensesbyAmountRange(@Param("userId") Long userId, @Param("minAmount") BigDecimal minAmount,
			@Param("maxAmount") BigDecimal maxAmount);

	@Query(value = """
			SELECT *
			FROM expenses
			WHERE user_id = :userId
			  AND updatetime BETWEEN :startDate AND :endDate
			""", nativeQuery = true)
	List<Expenses> getAllExpensesbyDateRange(@Param("userId") Long userId, @Param("startDate") LocalDateTime startDate,
			@Param("endDate") LocalDateTime endDate);

}

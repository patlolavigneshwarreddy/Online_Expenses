package com.example.expenses_server.controller.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.expenses_server.entity.Expenses;

public interface ReportSummeryRepo extends JpaRepository<Expenses, Long> {

	    @Query(value = """
	        SELECT YEAR(updatetime) AS year,
	               MONTH(updatetime) AS month,
	               SUM(debitamount) AS totalAmount,
	               COUNT(*) AS expenseCount
	        FROM expenses
	        WHERE user_id = :userId
	        GROUP BY YEAR(updatetime), MONTH(updatetime)
	        ORDER BY YEAR(updatetime), MONTH(updatetime)
	        """, nativeQuery = true)
	    List<Object[]> getMonthlySummary(@Param("userId") Long userId);
	
	    @Query(value = """
	    	    SELECT YEAR(updatetime) AS year,
	    	           MONTH(updatetime) AS month,
	    	           category_id,
	    	           SUM(debitamount) AS totalAmount,
	    	           COUNT(*) AS expenseCount
	    	    FROM expenses
	    	    WHERE user_id = :userId
	    	    GROUP BY YEAR(updatetime), MONTH(updatetime), category_id
	    	    ORDER BY YEAR(updatetime), MONTH(updatetime), category_id
	    	    """, nativeQuery = true)
	    	List<Object[]> getMonthlyCategorySummary(@Param("userId") Long userId);

}


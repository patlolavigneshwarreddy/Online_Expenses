package com.example.expenses_server.controller.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expenses_server.controller.record.MonthlyCategorySummary;
import com.example.expenses_server.controller.record.MonthlySummary;
import com.example.expenses_server.controller.repo.ReportSummeryRepo;
import com.example.expenses_server.controller.service.ReportSummeryService;

@Service
public class ReportSummeryServiceImpl implements ReportSummeryService {

	@Autowired
	ReportSummeryRepo reportSummeryRepo;
	
	
	
	
	
	@Override
	    public List<MonthlySummary> getMonthlySummary(Long userId) {
	        List<Object[]> results = reportSummeryRepo.getMonthlySummary(userId);
	        List<MonthlySummary> summaries = new ArrayList<>();

	        for (Object[] row : results) {
	            int year = ((Number) row[0]).intValue();
	            int month = ((Number) row[1]).intValue();
	            Double total = (Double) row[2];
	            long count = ((Number) row[3]).longValue();

	            summaries.add(new MonthlySummary(year, month, total, count));
	        }

	        return summaries;
	    }

	public List<MonthlyCategorySummary> getMonthlyCategorySummary(Long userId) {
	    List<Object[]> results = reportSummeryRepo.getMonthlyCategorySummary(userId);
	    List<MonthlyCategorySummary> summaries = new ArrayList<>();

	    for (Object[] row : results) {
	        int year = ((Number) row[0]).intValue();
	        int month = ((Number) row[1]).intValue();
	        Long categoryId = ((Number) row[2]).longValue();
	        Double total = (Double) row[3];
	        long count = ((Number) row[4]).longValue();

	        summaries.add(new MonthlyCategorySummary(year, month, categoryId, total, count));
	    }

	    return summaries;
	}



}






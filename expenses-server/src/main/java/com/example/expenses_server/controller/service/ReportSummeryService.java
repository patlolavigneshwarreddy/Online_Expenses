package com.example.expenses_server.controller.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.expenses_server.controller.record.MonthlyCategorySummary;
import com.example.expenses_server.controller.record.MonthlySummary;

@Service
public interface ReportSummeryService {

	//monthly report
	 public List<MonthlySummary> getMonthlySummary(Long userId);
	
	 //Category Monthly wise summary 
	 public List<MonthlyCategorySummary> getMonthlyCategorySummary(Long userId);

}

package com.example.expenses_server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expenses_server.controller.record.MonthlyCategorySummary;
import com.example.expenses_server.controller.record.MonthlySummary;
import com.example.expenses_server.controller.service.ReportSummeryService;
@RestController
@RequestMapping("/reportsummery")
public class ReportSummeryController {
//		@Autowired 
//		ReportSummeryService reportsummery;
//
//		
//		    @GetMapping("/monthly")
//		    public ResponseEntity<List<MonthlySummary>> getMonthlySummary(
//		            @RequestHeader("X-User-Id") Long userId) {
//		        List<MonthlySummary> summaries = reportsummery.getMonthlySummary(userId);
//		        return ResponseEntity.ok(summaries);
//		    }
//
//		    @GetMapping("/monthlycategory")
//		    public ResponseEntity<List<MonthlyCategorySummary>> getMonthlyCategorySummary(
//		            @RequestHeader("X-User-Id") Long userId) {
//		        List<MonthlyCategorySummary> summaries = reportsummery.getMonthlyCategorySummary(userId);
//		        return ResponseEntity.ok(summaries);
//		    }
		}


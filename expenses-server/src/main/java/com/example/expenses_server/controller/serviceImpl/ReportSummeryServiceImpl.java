package com.example.expenses_server.controller.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.expenses_server.controller.record.MonthlyCategorySummary;
import com.example.expenses_server.controller.record.MonthlySummary;
import com.example.expenses_server.controller.repo.ReportSummeryRepo;
import com.example.expenses_server.controller.service.ReportSummeryService;
import com.example.expenses_server.dto.CategoryDto;
import com.example.expenses_server.dto.MonthlyCategorySummaryDto;
import com.example.expenses_server.feignClient.CategoryClient;

@Service
public class ReportSummeryServiceImpl implements ReportSummeryService {

	@Autowired
	ReportSummeryRepo reportSummeryRepo;

	@Autowired
	CategoryClient categoryClient;

	@Override
	public List<MonthlySummary> getMonthlySummary(Long userId) {
		return reportSummeryRepo.getMonthlyreportSummary(userId);
	}

	public List<MonthlyCategorySummary> getMonthlyCategorySummary(Long userId) {
		List<MonthlyCategorySummary> summaries = new ArrayList<>();

		List<MonthlyCategorySummaryDto> result = reportSummeryRepo.getMonthlyCategorynameSummary(userId);

		CategoryDto clientcategoryDto = new CategoryDto();
		for (MonthlyCategorySummaryDto dto : result) {
			if (dto.getCategoryid() != null) {
				clientcategoryDto = categoryClient.getCategoryById(dto.getCategoryid());
			}
			summaries.add(new MonthlyCategorySummary(dto.getYear(), dto.getMonth(), clientcategoryDto.getName(),
					dto.getTotalAmount(), dto.getExpenseCount()));
		}

		return summaries;
	}

}

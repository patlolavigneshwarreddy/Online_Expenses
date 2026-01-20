package com.example.expenses_server.controller.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.expenses_server.controller.record.MonthlyCategorySummary;
import com.example.expenses_server.controller.record.MonthlySummary;
import com.example.expenses_server.controller.repo.ReportSummeryRepo;
import com.example.expenses_server.dto.CategoryDto;
import com.example.expenses_server.dto.MonthlyCategorySummaryDto;
import com.example.expenses_server.feignClient.CategoryClient;

@ExtendWith(MockitoExtension.class)
public class ReportSummeryServiceImplTest {

    @Mock
    ReportSummeryRepo reportSummeryRepo;

    @Mock
    CategoryClient categoryClient;

    @InjectMocks
    ReportSummeryServiceImpl service;

    @Test
    void getMonthlySummary_positive_returnsList() {
        List<MonthlySummary> data = new ArrayList<>();
        data.add(new MonthlySummary(2023, 1, 100.0, 2L));
        when(reportSummeryRepo.getMonthlyreportSummary(1L)).thenReturn(data);

        List<MonthlySummary> res = service.getMonthlySummary(1L);
        assertThat(res).isEqualTo(data);
    }

    @Test
    void getMonthlyCategorySummary_positive_resolvesCategoryNames() {
        MonthlyCategorySummaryDto dto = new MonthlyCategorySummaryDto();
        dto.setYear(2023);
        dto.setMonth(1);
        dto.setCategoryid(10L);
        dto.setTotalAmount(150.0);
        dto.setExpenseCount(3L);

        List<MonthlyCategorySummaryDto> list = List.of(dto);
        when(reportSummeryRepo.getMonthlyCategorynameSummary(1L)).thenReturn(list);

        when(categoryClient.getCategoryById(10L)).thenReturn(new CategoryDto(10L, "Food"));

        List<MonthlyCategorySummary> res = service.getMonthlyCategorySummary(1L);
        assertThat(res).hasSize(1);
        assertThat(res.get(0).categoryname()).isEqualTo("Food");
    }

    @Test
    void getMonthlyCategorySummary_negative_categoryServiceFallback() {
        MonthlyCategorySummaryDto dto = new MonthlyCategorySummaryDto();
        dto.setYear(2023);
        dto.setMonth(1);
        dto.setCategoryid(10L);
        dto.setTotalAmount(150.0);
        dto.setExpenseCount(3L);

        List<MonthlyCategorySummaryDto> list = List.of(dto);
        when(reportSummeryRepo.getMonthlyCategorynameSummary(1L)).thenReturn(list);

        // Simulate fallback: category client returns id -1
        when(categoryClient.getCategoryById(10L)).thenReturn(new CategoryDto(-1L, "Failed to retrieve category. Please try again later."));

        List<MonthlyCategorySummary> res = service.getMonthlyCategorySummary(1L);
        assertThat(res).hasSize(1);
        assertThat(res.get(0).categoryname()).contains("Failed to retrieve");
    }

}

package com.example.expenses_server.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.List;

import com.example.expenses_server.controller.record.MonthlyCategorySummary;
import com.example.expenses_server.controller.service.ReportSummeryService;
import com.example.expenses_server.dto.CategoryDto;
import com.example.expenses_server.entity.Expenses;
import com.example.expenses_server.feignClient.CategoryClient;
import com.example.expenses_server.controller.service.ExpensesService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.example.expenses_server.exceptions.GlobalExceptionHandler;

@ExtendWith(SpringExtension.class)
@Import(GlobalExceptionHandler.class)
public class ExpensesControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper mapper;

    @Mock
    ExpensesService expensesService;

    @Mock
    ReportSummeryService reportSummeryService;

    @Mock
    CategoryClient categoryClient;

//    @Test
//    void addexpenses_positive_returnsCreated() throws Exception {
//        Expenses e = new Expenses();
//        e.setUserId(1L);
//        e.setCategoryId(2L);
//        e.setDebitamount(50.0);
//
//        String body = mapper.writeValueAsString(e);
//
//        mvc.perform(post("/expenses").contentType(MediaType.APPLICATION_JSON).content(body).header("X-User-Id", "1"))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.userId").value(1));
//    }

//    @Test
//    void addexpenses_negative_missingHeader_returns400() throws Exception {
//        Expenses e = new Expenses();
//        e.setUserId(1L);
//        String body = mapper.writeValueAsString(e);
//
//        mvc.perform(post("/expenses").contentType(MediaType.APPLICATION_JSON).content(body))
//                .andExpect(status().isBadRequest());
//    }

//    @Test
//    void getbyId_positive_returnsExpense() throws Exception {
//        Expenses e = new Expenses();
//        e.setUserId(1L);
//        when(expensesService.findbyId(1L)).thenReturn(e);
//
//        mvc.perform(get("/expenses/1").header("X-User-Id", "1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.userId").value(1));
//    }

//    @Test
//    void getMonthlyCategorySummary_positive_andFeignFallback_handling() throws Exception {
//        MonthlyCategorySummary mcs = new MonthlyCategorySummary(2023, 1, "Food", 100.0, 2L);
//        when(reportSummeryService.getMonthlyCategorySummary(1L)).thenReturn(List.of(mcs));
//
//        mvc.perform(get("/expenses/monthlycategory").header("X-User-Id", "1"))
//                .andExpect(status().isOk());
//
//        // category name endpoint that calls feign
//        when(categoryClient.getCategoryById(10L)).thenReturn(new CategoryDto(-1L, "Failed to retrieve category. Please try again later."));
//        when(categoryClient.getCategoryById(1L)).thenReturn(new CategoryDto(1L, "Food"));
//
//        mvc.perform(get("/expenses/category/name/1").header("X-User-Id", "1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.categoryId").value(1));
//
//        mvc.perform(get("/expenses/category/name/10").header("X-User-Id", "1"))
//                .andExpect(status().isServiceUnavailable())
//                .andExpect(jsonPath("$.categoryId").value(-1));
//    }

//    @Test
//    void getAllExpensesbyAmountRange_positive_returnsOk() throws Exception {
//        when(expensesService.getAllExpensesbyAmountRange(Mockito.eq(1L), any(BigDecimal.class), any(BigDecimal.class)))
//                .thenReturn(List.of());
//
//        mvc.perform(get("/expenses/amount-range?minAmount=10&maxAmount=100").header("X-User-Id", "1"))
//                .andExpect(status().isOk());
//    }

}

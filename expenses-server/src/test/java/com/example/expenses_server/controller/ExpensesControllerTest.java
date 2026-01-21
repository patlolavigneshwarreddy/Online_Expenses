package com.example.expenses_server.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import com.example.expenses_server.controller.service.ReportSummeryService;
import com.example.expenses_server.entity.Expenses;
import com.example.expenses_server.feignClient.CategoryClient;
import com.example.expenses_server.controller.service.ExpensesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExpensesControllerTest {



    @Mock
    ExpensesService expensesService;

    @Mock
    ReportSummeryService reportSummeryService;

    @Mock
    CategoryClient categoryClient;
    
    @InjectMocks
    ExpensesController expensesController;

//    @Test
//    void getMonthlyCategorySummary() {
//        MonthlyCategorySummary summary = new MonthlyCategorySummary(2023, 8, "Food", 1000.0, 5);
//        when(reportSummeryService.getMonthlyCategorySummary(1L))
//            .thenReturn(List.of(summary));
//        when(categoryClient.getCategoryById(1L))
//            .thenReturn(new CategoryDto(1L, "Food"));
//
//    }

    @Test
    void addExpense() throws Exception {
       Expenses expenses = new Expenses(1L,  1L,1L, 100.00,"Lunch", LocalDateTime.now(), null);
         Mockito.doNothing().when(expensesService).addexpenses(expenses);
        expensesController.addexpenses(1L, expenses);
        Mockito.verify(expensesService).addexpenses(expenses);

    }

       @Test
       void updateExpense() throws Exception {
            Expenses expenses = new Expenses(1L,  1L,1L, 150.00,"Dinner", LocalDateTime.now(), null);
                Mockito.when(expensesService.updateExpense(1L, expenses)).thenReturn(expenses);
             expensesController.updateExpense(1L,1L, expenses);
             Mockito.verify(expensesService).updateExpense(1L, expenses);
       }

       @Test
       void deleteExpense() throws Exception {
            Mockito.doNothing().when(expensesService).deletebyId(1L);
            expensesController.deletebyId(1L,   1L);
            Mockito.verify(expensesService).deletebyId(1L);
       }

//       @Test
//         void getExpensesByUserId() throws Exception {
//                Expenses expense1 = new Expenses(1L,  1L,1L, 50.00,"Breakfast", LocalDateTime.now(), null);
//                Expenses expense2 = new Expenses(2L,  1L,2L, 200.00,"Groceries", LocalDateTime.now(), null);
//                Mockito.when(expensesService.findbyUserId(1L)).thenReturn(List.of(expense1, expense2));
//                expensesController.getbyId(1L, 1L);
//           Mockito.<ExpensesService>verify(expensesService).findbyUserId(1L);
//       }

         @Test
            void getExpensesByCategory() throws Exception {
                    Expenses expense1 = new Expenses(1L,  1L,1L, 75.00,"Snack", LocalDateTime.now(), null);
                    Mockito.when(expensesService.getAllExpensesbyCategory(1L, 1L)).thenReturn(List.of(expense1));
                    expensesController.getAllExpensesbyCategory(1L, 1L);
                    Mockito.verify(expensesService).getAllExpensesbyCategory(1L, 1L);
            }

            @Test
                void getExpensesByAmountRange() throws Exception {
                      Expenses expense1 = new Expenses(1L,  1L,1L, 120.00,"Lunch", LocalDateTime.now(), null);
                      Expenses expense2 = new Expenses(2L,  1L,2L, 180.00,"Dinner", LocalDateTime.now(), null);
                      Mockito.when(expensesService.getAllExpensesbyAmountRange(1L, BigDecimal.valueOf(100), BigDecimal.valueOf(200)))
                            .thenReturn(List.of(expense1, expense2));
                      expensesController.getAllExpensesbyAmountRange(1L, BigDecimal.valueOf(100), BigDecimal.valueOf(200));
                      Mockito.verify(expensesService).getAllExpensesbyAmountRange(1L, BigDecimal.valueOf(100), BigDecimal.valueOf(200));
                }
}

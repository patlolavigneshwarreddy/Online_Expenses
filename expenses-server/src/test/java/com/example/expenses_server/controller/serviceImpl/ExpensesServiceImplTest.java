package com.example.expenses_server.controller.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.expenses_server.controller.repo.ExpensesRepo;
import com.example.expenses_server.entity.Expenses;
import com.example.expenses_server.exceptions.ResourceNotFoundException;

@ExtendWith(MockitoExtension.class)
public class ExpensesServiceImplTest {

    @Mock
    ExpensesRepo expensesRepo;

    @InjectMocks
    ExpensesServiceImpl expensesService;

    @Test
    void addexpenses_callsSave() {
        Expenses e = new Expenses();
        e.setUserId(1L);
        e.setCategoryId(2L);
        e.setDebitamount(100.0);

        expensesService.addexpenses(e);

        verify(expensesRepo).save(e);
    }

    @Test
    void findbyId_positive_returnsExpense() {
        Expenses e = new Expenses();
        e.setUserId(1L);
        when(expensesRepo.findById(1L)).thenReturn(Optional.of(e));

        Expenses result = expensesService.findbyId(1L);
        assertThat(result).isSameAs(e);
    }

    @Test
    void findbyId_negative_throwsResourceNotFound() {
        when(expensesRepo.findById(99L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> expensesService.findbyId(99L));
    }

    @Test
    void updateExpense_positive_updatesFieldsAndSaves() {
        Expenses existing = new Expenses();
        existing.setUserId(1L);
        existing.setCategoryId(5L);
        existing.setDebitamount(10.0);

        Expenses updated = new Expenses();
        updated.setUserId(2L);
        updated.setCategoryId(6L);
        updated.setDebitamount(20.0);
        updated.setDescription("updated");

        when(expensesRepo.findById(1L)).thenReturn(Optional.of(existing));
        when(expensesRepo.save(any(Expenses.class))).thenAnswer(i -> i.getArgument(0));

        Expenses res = expensesService.updateExpense(1L, updated);
        assertThat(res.getUserId()).isEqualTo(2L);
        assertThat(res.getCategoryId()).isEqualTo(6L);
        assertThat(res.getDebitamount()).isEqualTo(20.0);
        assertThat(res.getDescription()).isEqualTo("updated");

        verify(expensesRepo).save(existing);
    }

    @Test
    void updateExpense_negative_missing_throwsRuntime() {
        when(expensesRepo.findById(5L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> expensesService.updateExpense(5L, new Expenses()));
    }

}

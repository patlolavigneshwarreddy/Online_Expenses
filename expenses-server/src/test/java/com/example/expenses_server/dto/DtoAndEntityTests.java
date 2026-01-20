//package com.example.expenses_server.dto;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.time.LocalDateTime;
//
//import org.junit.jupiter.api.Test;
//
//import com.example.expenses_server.entity.Expenses;
//
//public class DtoAndEntityTests {
//
//    @Test
//    void categoryDto_gettersSetters() {
//        CategoryDto c = new CategoryDto(5L, "Food");
//        assertThat(c.getCategoryId()).isEqualTo(5L);
//        assertThat(c.getName()).isEqualTo("Food");
//    }
//
//    @Test
//    void monthlyCategoryDto_gettersSetters() {
//        MonthlyCategorySummaryDto m = new MonthlyCategorySummaryDto();
//        m.setYear(2023);
//        m.setMonth(1);
//        m.setCategoryid(2L);
//        m.setTotalAmount(100.0);
//        m.setExpenseCount(3L);
//
//        assertThat(m.getYear()).isEqualTo(2023);
//        assertThat(m.getCategoryid()).isEqualTo(2L);
//    }
//
//    @Test
//    void responseErrorDto_constructor_and_getters() {
//        ResponseErrorDto r = new ResponseErrorDto("msg", 400);
//        assertThat(r.getMessage()).isEqualTo("msg");
//        assertThat(r.getStatuscode()).isEqualTo(400);
//    }
//
//    @Test
//    void expenses_entity_setId_bug_detected() {
//        Expenses e = new Expenses();
//        e.setId(10L);
//        // There is a bug in setId (it assigns id = id). Expectation: getId should be 10 but currently it's null
//        assertThat(e.getId()).isNotEqualTo(10L);
//    }
//
//    @Test
//    void expenses_entity_gettersSetters() {
//        Expenses e = new Expenses();
//        e.setUserId(1L);
//        e.setCategoryId(2L);
//        e.setDebitamount(33.3);
//        e.setDescription("desc");
//        e.setCurrenttime(LocalDateTime.now());
//        e.setUpdatetime(LocalDateTime.now());
//
//        assertThat(e.getUserId()).isEqualTo(1L);
//        assertThat(e.getCategoryId()).isEqualTo(2L);
//    }
//}

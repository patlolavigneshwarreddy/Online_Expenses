//package com.example.expenses_server.controller.repo;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.example.expenses_server.entity.Expenses;
//
//@ExtendWith(SpringExtension.class)
////@DataJpaTest
//public class ExpensesRepoTest {
//
//    @Autowired
//    ExpensesRepo repo;
//
//    @Test
//    void findByUserId_and_category_and_ranges_work() {
//        Expenses e1 = new Expenses();
//        e1.setUserId(1L);
//        e1.setCategoryId(2L);
//        e1.setDebitamount(50.0);
//        e1.setDescription("d1");
//        e1.setCurrenttime(LocalDateTime.now());
//        e1.setUpdatetime(LocalDateTime.now());
//
//        Expenses e2 = new Expenses();
//        e2.setUserId(1L);
//        e2.setCategoryId(3L);
//        e2.setDebitamount(150.0);
//        e2.setDescription("d2");
//        e2.setCurrenttime(LocalDateTime.now());
//        e2.setUpdatetime(LocalDateTime.now());
//
//        repo.save(e1);
//        repo.save(e2);
//
//        List<Expenses> byUser = repo.findByUserId(1L);
//        assertThat(byUser).hasSize(2);
//
//        List<Expenses> byCategory = repo.getAllExpensesbyCategory(1L, 2L);
//        assertThat(byCategory).hasSize(1);
//
//        List<Expenses> byAmount = repo.getAllExpensesbyAmountRange(1L, new BigDecimal("10"), new BigDecimal("100"));
//        assertThat(byAmount).hasSize(1);
//
//        List<Expenses> byDate = repo.getAllExpensesbyDateRange(1L, LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
//        assertThat(byDate.size()).isGreaterThanOrEqualTo(1);
//    }
//
//}

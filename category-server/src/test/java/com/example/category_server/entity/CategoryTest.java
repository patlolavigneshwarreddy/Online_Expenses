package com.example.category_server.entity;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    @Test
    void gettersAndSetters_andToString() {
        Category c = new Category();
        c.setCategoryId(10L);
        c.setCategoryname("food");
        c.setDescription("desc");
        Timestamp now = new Timestamp(System.currentTimeMillis());
        c.setCurrenttime(now);
        c.setUpdatetime(now);

        assertEquals(10L, c.getCategoryId());
        assertEquals("food", c.getCategoryname());
        assertEquals("desc", c.getDescription());
        assertEquals(now, c.getCurrenttime());
        assertEquals(now, c.getUpdatetime());

        String s = c.toString();
        assertTrue(s.contains("categoryId=10"));
        assertTrue(s.contains("categoryname=food"));
    }
}

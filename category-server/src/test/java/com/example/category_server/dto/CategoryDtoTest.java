package com.example.category_server.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryDtoTest {

    @Test
    void gettersSettersAndToString() {
        CategoryDto dto = new CategoryDto(2L, "books");
        assertEquals(2L, dto.getCategoryId());
        assertEquals("books", dto.getName());

        dto.setCategoryId(3L);
        dto.setName("games");
        assertEquals(3L, dto.getCategoryId());
        assertEquals("games", dto.getName());

        String s = dto.toString();
        assertTrue(s.contains("CategoryDto"));
    }
}

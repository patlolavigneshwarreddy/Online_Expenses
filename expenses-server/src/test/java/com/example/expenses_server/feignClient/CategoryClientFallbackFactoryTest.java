package com.example.expenses_server.feignClient;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.expenses_server.dto.CategoryDto;

public class CategoryClientFallbackFactoryTest {

    @Test
    void fallback_returnsNegativeIdAndMessage() {
        CategoryClientFallbackFactory f = new CategoryClientFallbackFactory();
        CategoryDto dto = f.getCategoryById(1L);
        assertThat(dto.getCategoryId()).isEqualTo(-1L);
        assertThat(dto.getName()).contains("Failed to retrieve");
    }
}

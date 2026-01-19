package com.example.expenses_server.feignClient;

import com.example.expenses_server.dto.CategoryDto;

import org.springframework.stereotype.Component;

@Component
public class CategoryClientFallbackFactory implements CategoryClient {

	@Override
	public CategoryDto getCategoryById(Long id) {
		// TODO Auto-generated method stub
		return new CategoryDto(-1L, // fallback categoryId
				"Failed to retrieve category. Please try again later.");

	}
}

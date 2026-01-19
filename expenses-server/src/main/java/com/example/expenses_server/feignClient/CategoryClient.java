package com.example.expenses_server.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.expenses_server.dto.CategoryDto;

@FeignClient(
	    name = "category-server",
	    fallback = CategoryClientFallbackFactory.class,
	    path = "/category"
//	    url = "http://localhost:8080" 
	)
	public interface CategoryClient {

	    @GetMapping("/name/{id}")
	    CategoryDto getCategoryById(@PathVariable("id") Long id);
	}


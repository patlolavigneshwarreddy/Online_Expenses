package com.example.category_server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.category_server.entity.Category;

@Service
public interface CategoryService {

	void addCategory(Category category);

	Optional<Category> fetchById(Long id);
	
	List<Category> findAll();
}

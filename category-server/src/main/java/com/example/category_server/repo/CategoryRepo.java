package com.example.category_server.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.category_server.entity.Category;

public interface CategoryRepo  extends JpaRepository<Category, Long>{
	
	Optional<Category> findById(Long id);
	
	List<Category> findAll();
	
}

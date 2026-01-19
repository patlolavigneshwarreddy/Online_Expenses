package com.example.category_server.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.category_server.dto.CategoryDto;
import com.example.category_server.entity.Category;

public interface CategoryRepo  extends JpaRepository<Category, Long>{
	
	Optional<Category> findById(Long id);
	
	List<Category> findAll();
	@Query(
		    value = """
		        SELECT c.category_id AS id, c.categoryname AS name
		        FROM category c
		        WHERE c.category_id = :categoryId
		    """,
		    nativeQuery = true
		)	    Optional<CategoryDto> getCategoryNameById(@Param("categoryId") Long categoryId);
	
}

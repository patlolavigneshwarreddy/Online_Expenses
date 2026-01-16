package com.example.category_server.serviceImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.category_server.entity.Category;
import com.example.category_server.repo.CategoryRepo;
import com.example.category_server.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo categoryRepo;

	@Override
	public void addCategory(Category category) {
		Category categoryvalue = new Category();
		categoryvalue.setCategoryname(category.getCategoryname());
		categoryvalue.setDescription(category.getDescription());
		categoryRepo.save(category);

	}

	@Override
	public Optional<Category> fetchById(Long id) {
		// TODO Auto-generated method stub
		Optional<Category> category = categoryRepo.findById(id);
		return category;
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

}

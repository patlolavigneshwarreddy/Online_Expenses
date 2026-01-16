package com.example.category_server.serviceImpl;

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

	@Override
	public Category updateCategory(Long id, Category updateCategory) {
		// TODO Auto-generated method stub
		Category existing = categoryRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Category not found with id " + id));

		// Update only allowed fields
		if (updateCategory.getCategoryname() != null) {
			existing.setCategoryname(updateCategory.getCategoryname());
		}
		if (updateCategory.getDescription() != null) {
			existing.setDescription(updateCategory.getDescription());
		}
		// Save will automatically update `updatetime` because of @UpdateTimestamp
		return categoryRepo.save(existing);
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepo.deleteById(id);
	}

}

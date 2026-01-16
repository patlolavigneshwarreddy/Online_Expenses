package com.example.category_server.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.category_server.entity.Category;
import com.example.category_server.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		categoryService.addCategory(category);
		return new ResponseEntity<Category>(category, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable Long id){
	Optional<Category> category =	categoryService.fetchById(id);
		return new ResponseEntity<Optional<Category>>(category, HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories(){
		List<Category> categories = categoryService.findAll();
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable Long id,
            @RequestBody Category updateCategory){
		Category category = categoryService.updateCategory(id, updateCategory);
        return ResponseEntity.ok(category);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
		return ResponseEntity.ok("category deleted");
		
		
	}
	
}

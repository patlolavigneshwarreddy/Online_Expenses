package com.example.category_server.controller;

import com.example.category_server.entity.Category;
import com.example.category_server.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    void setUp() {
        // MockitoExtension takes care of init
    }

    @Test
    void testAddCategory() {
        Category mockCategory = new Category();
        mockCategory.setCategoryId(Long.valueOf(1));
        mockCategory.setCategoryname("food");
        mockCategory.setDescription("food iteams");// Create or mock a Category object
        Mockito.doNothing().when(categoryService).addCategory(mockCategory);
        categoryController.addCategory(mockCategory);
        Mockito.verify(categoryService).addCategory(mockCategory);
         // Additional assertions or verifications can be added here
    }

    @Test
    void testAddCategory_NullCategory() {
        Category nullCategory = null;
        Mockito.doThrow(new IllegalArgumentException("Category cannot be null")).when(categoryService).addCategory(nullCategory);
        try {
            categoryController.addCategory(nullCategory);
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
        Mockito.verify(categoryService).addCategory(nullCategory);
        // Additional assertions or verifications can be added here
    }

    @Test
    void testGetCategoryById() {
        Long categoryId = Long.valueOf(1);
        Category mockCategory = new Category();
        mockCategory.setCategoryId(categoryId);
        mockCategory.setCategoryname("food");
        mockCategory.setDescription("food iteams");
        Mockito.when(categoryService.fetchById(categoryId)).thenReturn(java.util.Optional.of(mockCategory));
        categoryController.getCategoryById(categoryId);
        Mockito.verify(categoryService).fetchById(categoryId);
         // Additional assertions or verifications can be added here
    }

    @Test
    void testGetAllCategories() {
        Mockito.when(categoryService.findAll()).thenReturn(java.util.Arrays.asList(new Category(), new Category()));
        categoryController.getAllCategories();
        Mockito.verify(categoryService).findAll();
         // Additional assertions or verifications can be added here
    }

    @Test
    void testUpdateCategory() {
        Long categoryId = Long.valueOf(1);
        Category updateCategory = new Category();
        updateCategory.setCategoryname("updatedName");
        updateCategory.setDescription("updatedDescription");
        Category updatedCategory = new Category();
        updatedCategory.setCategoryId(categoryId);
        updatedCategory.setCategoryname("updatedName");
        updatedCategory.setDescription("updatedDescription");
        Mockito.when(categoryService.updateCategory(categoryId, updateCategory)).thenReturn(updatedCategory);
        categoryController.updateCategory(categoryId, updateCategory);
        Mockito.verify(categoryService).updateCategory(categoryId, updateCategory);
         // Additional assertions or verifications can be added here
    }

    @Test
    void testUpdateCategory_NullUpdate() {
        Long categoryId = Long.valueOf(1);
        Category nullUpdateCategory = null;
        Mockito.doThrow(new IllegalArgumentException("Update category cannot be null"))
               .when(categoryService).updateCategory(categoryId, nullUpdateCategory);
        try {
            categoryController.updateCategory(categoryId, nullUpdateCategory);
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
        Mockito.verify(categoryService).updateCategory(categoryId, nullUpdateCategory);
         // Additional assertions or verifications can be added here
    }

    @Test
    void testDeleteCategory() {
        Long categoryId = Long.valueOf(1);
        Mockito.doNothing().when(categoryService).deleteCategory(categoryId);
        categoryController.deleteCategory(categoryId);
        Mockito.verify(categoryService).deleteCategory(categoryId);
         // Additional assertions or verifications can be added here
    }

    @Test
    void testDeleteCategory_NonExistentId() {
        Long nonExistentId = Long.valueOf(999);
        Mockito.doThrow(new RuntimeException("Category not found")).when(categoryService).deleteCategory(nonExistentId);
        try {
            categoryController.deleteCategory(nonExistentId);
        } catch (RuntimeException e) {
            // Expected exception
        }
        Mockito.verify(categoryService).deleteCategory(nonExistentId);
        // Additional assertions or verifications can be added here
    }

    @Test
    void testGetCategoryNameById() {
        Long categoryId = Long.valueOf(1);
        Mockito.when(categoryService.getCategoryNameById(categoryId)).thenReturn(java.util.Optional.empty());
        categoryController.getCategoryNameById(categoryId);
        Mockito.verify(categoryService).getCategoryNameById(categoryId);
         // Additional assertions or verifications can be added here
    }

    @Test
    void testGetCategoryNameById_NotFound() {
        Long categoryId = Long.valueOf(999);
        Mockito.when(categoryService.getCategoryNameById(categoryId)).thenReturn(java.util.Optional.empty());
        categoryController.getCategoryNameById(categoryId);
        Mockito.verify(categoryService).getCategoryNameById(categoryId);
         // Additional assertions or verifications can be added here
    }


    @Test
    void testUpdateCategory_NonExistentId() {
        Long nonExistentId = Long.valueOf(999);
        Category updateCategory = new Category();
        updateCategory.setCategoryname("updatedName");
        updateCategory.setDescription("updatedDescription");
        Mockito.when(categoryService.updateCategory(nonExistentId, updateCategory))
               .thenThrow(new RuntimeException("Category not found"));
        try {
            categoryController.updateCategory(nonExistentId, updateCategory);
        } catch (RuntimeException e) {
            // Expected exception
        }
        Mockito.verify(categoryService).updateCategory(nonExistentId, updateCategory);
         // Additional assertions or verifications can be added here
    }


    @Test
    void testGetCategoryById_NonExistentId() {
        Long nonExistentId = Long.valueOf(999);
        Mockito.when(categoryService.fetchById(nonExistentId)).thenReturn(java.util.Optional.empty());
        categoryController.getCategoryById(nonExistentId);
        Mockito.verify(categoryService).fetchById(nonExistentId);
         // Additional assertions or verifications can be added here
    }

    @Test
    void testGetAllCategories_EmptyList() {
        Mockito.when(categoryService.findAll()).thenReturn(java.util.Collections.emptyList());
        categoryController.getAllCategories();
        Mockito.verify(categoryService).findAll();
         // Additional assertions or verifications can be added here
    }

}


package com.example.category_server.serviceImpl;

import com.example.category_server.dto.CategoryDto;
import com.example.category_server.entity.Category;
import com.example.category_server.repo.CategoryRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

    @Mock
    private CategoryRepo categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    void addCategory_callsSave() {
        Category category = new Category();
        category.setCategoryname("food");
        category.setDescription("desc");

        // no stubbing needed for void method
        categoryService.addCategory(category);

        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void fetchById_returnsOptionalCategory() {
        Category category = new Category();
        category.setCategoryId(1L);
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));

        Optional<Category> result = categoryService.fetchById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getCategoryId());
    }

    @Test
    void findAll_returnsList() {
        Category a = new Category();
        Category b = new Category();
        List<Category> list = Arrays.asList(a, b);
        when(categoryRepository.findAll()).thenReturn(list);

        List<Category> result = categoryService.findAll();

        assertEquals(2, result.size());
    }

    @Test
    void updateCategory_updatesExisting() {
        Category existing = new Category();
        existing.setCategoryId(1L);
        existing.setCategoryname("old");
        existing.setDescription("old desc");

        Category update = new Category();
        update.setCategoryname("new");
        update.setDescription(null);

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(categoryRepository.save(any(Category.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Category result = categoryService.updateCategory(1L, update);

        assertEquals("new", result.getCategoryname());
        assertEquals("old desc", result.getDescription(), "description should remain unchanged when update has null");
        verify(categoryRepository).save(existing);
    }

    @Test
    void updateCategory_whenNotFound_throws() {
        when(categoryRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> categoryService.updateCategory(99L, new Category()));
        assertTrue(ex.getMessage().contains("Category not found"));
    }

    @Test
    void deleteCategory_callsDeleteById() {
        doNothing().when(categoryRepository).deleteById(1L);

        categoryService.deleteCategory(1L);

        verify(categoryRepository).deleteById(1L);
    }

    @Test
    void getCategoryNameById_delegatesToRepo() {
        CategoryDto dto = new CategoryDto(1L, "food");
        when(categoryRepository.getCategoryNameById(1L)).thenReturn(Optional.of(dto));

        Optional<CategoryDto> result = categoryService.getCategoryNameById(1L);

        assertTrue(result.isPresent());
        assertEquals("food", result.get().getName());
    }
}

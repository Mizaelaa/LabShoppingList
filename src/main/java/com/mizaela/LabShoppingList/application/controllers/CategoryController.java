package com.mizaela.LabShoppingList.application.controllers;

import com.mizaela.LabShoppingList.application.dtos.CreateEditCategoryBody;
import com.mizaela.LabShoppingList.domain.category.Category;
import com.mizaela.LabShoppingList.domain.category.CategoryService;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> listCategories() {
        return categoryService.listCategories();
    }

    @PostMapping("/category")
    public Category createCategory(@RequestBody CreateEditCategoryBody body) {
        return categoryService.createCategory(body);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
    }
}

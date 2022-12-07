package com.mizaela.LabShoppingList.domain;

import com.mizaela.LabShoppingList.domain.category.Category;
import com.mizaela.LabShoppingList.domain.category.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CategoryRepositoryTests {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryRepositoryTests(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Test
    public void shouldSaveNewCategory() {
        var category = new Category();
        category.setName("test");
        category.setDescription("this is a test category");

        categoryRepository.save(category);
    }

    @Test
    public void shouldListAllCategories() {
        var category = new Category();
        category.setName("test 2");
        category.setDescription("this is a test category");
        categoryRepository.save(category);

        var categories = categoryRepository.findAll();
        categories.forEach(System.out::println);

        assertTrue(categoryRepository.count() > 0);
    }
}

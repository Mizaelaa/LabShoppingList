package com.mizaela.LabShoppingList.domain.category;

import com.mizaela.LabShoppingList.application.dtos.CreateEditCategoryBody;
import com.mizaela.LabShoppingList.domain.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public Category createCategory(CreateEditCategoryBody body) {
        if(categoryRepository.findByName(body.name()).isPresent())
            throw new RuntimeException("Category " + body.name() + " already exists.");

        var category = new Category();
        category.setName(body.name());
        category.setDescription(body.description());

        return categoryRepository.save(category);
    }

    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    public void deleteCategory(Long categoryId) {
        var category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException(
                        "Category with ID " + categoryId + " not found."
                ));
        var products = productRepository.findByCategory(category);

        if(!products.isEmpty()) throw new RuntimeException("Cannot delete this category because it has products.");

        categoryRepository.deleteById(categoryId);
    }
}

package com.mizaela.LabShoppingList.domain;

import com.mizaela.LabShoppingList.domain.category.Category;
import com.mizaela.LabShoppingList.domain.category.CategoryRepository;
import com.mizaela.LabShoppingList.domain.product.Product;
import com.mizaela.LabShoppingList.domain.product.ProductRepository;
import com.mizaela.LabShoppingList.domain.product.ProductStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductRepositoryTests {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ProductRepositoryTests(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Test
    public void shouldCreateNewProduct() {
        var category = createCategory("food", "Food");
        var product = new Product();
        product.setCategory(category);
        product.setProductName("Bacon");
        product.setPrice(16.90);
        product.setStatus(ProductStatus.NOT_BOUGHT);

        product = productRepository.save(product);
        assertNotNull(product.getId());
    }

    private Category createCategory(String name, String description) {
        var category = new Category();
        category.setName(name);
        category.setDescription(description);

        return categoryRepository.save(category);
    }
}

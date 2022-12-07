package com.mizaela.LabShoppingList.domain.product;

import com.mizaela.LabShoppingList.application.dtos.CreateEditProductBody;
import com.mizaela.LabShoppingList.domain.category.CategoryRepository;
import com.mizaela.LabShoppingList.domain.category.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product createProduct(CreateEditProductBody body) {
        var category = categoryRepository.findById(body.categoryId())
                .orElseThrow(() -> new RuntimeException(
                        "Category with ID " + body.categoryId() + " not found."
                ));

        var product = new Product();
        product.setCategory(category);
        product.setProductName(body.productName());
        product.setPrice(body.price());
        product.setStatus(body.status());

        return productRepository.save(product);
    }

    public Product editProduct(Long productId, CreateEditProductBody body) {
        var product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product with ID " + productId + " not found."));

        var category = categoryRepository.findById(body.categoryId())
                .orElseThrow(() -> new RuntimeException(
                        "Category with ID " + body.categoryId() + " not found."
                ));

        product.setCategory(category);
        product.setProductName(body.productName());
        product.setPrice(body.price());
        product.setStatus(body.status());

        return productRepository.save(product);
    }

    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }

    public Double calculateTotalBoughtValue() {
        var totalBoughtValue = 0.0;

        var products = productRepository.findByStatus(ProductStatus.BOUGHT);

        totalBoughtValue = products.stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);

        return totalBoughtValue;
    }
}

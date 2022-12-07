package com.mizaela.LabShoppingList.application.controllers;

import com.mizaela.LabShoppingList.application.dtos.CreateEditProductBody;
import com.mizaela.LabShoppingList.domain.product.Product;
import com.mizaela.LabShoppingList.domain.product.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody CreateEditProductBody body) {
        return productService.createProduct(body);
    }

    @PutMapping("/product/{id}")
    public Product editProduct(@PathVariable("id") Long id, @RequestBody CreateEditProductBody body) {
        return productService.editProduct(id, body);
    }

    @GetMapping("/products")
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/products/total")
    public Double getTotalBought() {
        return productService.calculateTotalBoughtValue();
    }
}

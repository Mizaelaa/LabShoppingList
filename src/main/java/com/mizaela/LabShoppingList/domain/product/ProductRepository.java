package com.mizaela.LabShoppingList.domain.product;

import com.mizaela.LabShoppingList.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
    List<Product> findByStatus(ProductStatus status);
}

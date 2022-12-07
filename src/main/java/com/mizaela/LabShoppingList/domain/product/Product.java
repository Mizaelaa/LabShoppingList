package com.mizaela.LabShoppingList.domain.product;

import com.mizaela.LabShoppingList.domain.category.Category;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Category category;
    private String productName;
    private Double price;
    @Enumerated(EnumType.ORDINAL)
    private ProductStatus status;
}

package com.mizaela.LabShoppingList.application.dtos;

import com.mizaela.LabShoppingList.domain.category.Category;
import com.mizaela.LabShoppingList.domain.product.ProductStatus;

public record CreateEditProductBody(
        Long categoryId,
        String productName,
        Double price,
        ProductStatus status
) {
}
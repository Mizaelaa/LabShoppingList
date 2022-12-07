package com.mizaela.LabShoppingList.domain.product;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ProductStatus {
    BOUGHT,
    NOT_BOUGHT;

//    @JsonCreator
//    public static ProductStatus fromText(String text) {
//        for(ProductStatus s : ProductStatus.values()) {
//            if(s.name().equals(text)) return s;
//        }
//
//        throw new RuntimeException("Invalid status " + text);
//    }
}

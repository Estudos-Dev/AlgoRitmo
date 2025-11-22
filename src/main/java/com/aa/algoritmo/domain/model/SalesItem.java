package com.aa.algoritmo.domain.model;

public record SalesItem(
        Integer id,
        Integer productId,
        String productName,
        Integer quantity,
        Integer price
) {
}

package com.aa.algoritmo.adapter.in.model.request;

public record SalesItemRequest(
        Integer productId,
        Integer quantity,
        Integer price) {
}

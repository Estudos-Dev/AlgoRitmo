package com.aa.algoritmo.adapter.in.model.response;

public record SalesItemResponse(Integer id,
                                Integer productId,
                                String productName,
                                Integer quantity,
                                Integer price) {
}

package com.aa.algoritmo.adapter.in.model.response;

import com.aa.algoritmo.domain.model.product.Product;

import java.time.LocalDateTime;
import java.util.List;

public record SalesResponse(
        Integer id,
        Integer sellerId,
        String sellerName,
        Integer clientId,
        String clientName,
        LocalDateTime date,
        List<Product> items,
        Integer total) {
}
package com.aa.algoritmo.adapter.in.model.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record SalesResponse(
        Integer id,
        Integer sellerId,
        String sellerName,
        Integer clientId,
        String clientName,
        LocalDateTime date,
        List<SalesItemResponse> items,
        BigDecimal total) {
}
package com.aa.algoritmo.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record Sales (
        Integer id,
        Integer sellerId,
        String sellerName,
        Integer clientId,
        String clientName,
        LocalDateTime date,
        List<SalesItem> items,
        BigDecimal total) {
}
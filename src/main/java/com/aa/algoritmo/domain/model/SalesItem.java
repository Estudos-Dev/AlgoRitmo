package com.aa.algoritmo.domain.model;

import java.math.BigDecimal;

public record SalesItem(
        Integer id,
        Integer productId,
        String productName,
        Integer quantity,
        BigDecimal price
) {}
package com.aa.algoritmo.adapter.in.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface SaleProjection {
    Integer getId();
    Integer getSellerId();
    String getSellerName();
    Integer getClientId();
    String getClientName();
    LocalDateTime getCreatedAt();
    BigDecimal getTotal();
}
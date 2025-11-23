package com.aa.algoritmo.adapter.in.model;

import java.math.BigDecimal;

public interface SaleItemProjection {
    Integer getId();
    Integer getProductId();
    String getProductName();
    BigDecimal getPrice();
    Integer getQuantity();
    Integer getSaleId();
}
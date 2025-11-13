package com.aa.algoritmo.ports.out.persistence;

import com.aa.algoritmo.adapter.in.model.request.SalesRequest;
import com.aa.algoritmo.adapter.out.persistence.entity.SalesEntity;

import java.util.List;

public interface SalesPersistencePort {
    List<SalesEntity> findAllProducts();
    SalesEntity createSales(SalesEntity salesEntity);
    SalesEntity updateProduct(Integer id, SalesRequest salesRequest);
    void deleteProduct(Integer id);
}
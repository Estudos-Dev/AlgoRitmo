package com.aa.algoritmo.ports.out.persistence;

import com.aa.algoritmo.adapter.in.model.request.SalesRequest;
import com.aa.algoritmo.adapter.out.persistence.entity.SalesEntity;
import com.aa.algoritmo.domain.model.Sales;

import java.util.List;

public interface SalesPersistencePort {
    List<Sales> findAllSales(Integer limit);
    SalesEntity createSale(SalesEntity salesEntity);
    SalesEntity updateSale(Integer id, SalesRequest salesRequest);
    void deleteSale(Integer id);
}
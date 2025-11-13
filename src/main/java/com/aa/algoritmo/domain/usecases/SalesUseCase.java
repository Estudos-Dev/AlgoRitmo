package com.aa.algoritmo.domain.usecases;

import com.aa.algoritmo.adapter.in.model.request.SalesRequest;
import com.aa.algoritmo.domain.model.Sales;
import com.aa.algoritmo.domain.model.product.Product;

import java.util.List;

public interface SalesUseCase {
    List<Sales> findAllSales();
    Sales createSales(SalesRequest salesRequest);
    Sales updateSales(Integer id, SalesRequest salesRequest);
    void deleteSalest(Integer id);
}

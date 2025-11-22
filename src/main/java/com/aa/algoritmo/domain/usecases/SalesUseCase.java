package com.aa.algoritmo.domain.usecases;

import com.aa.algoritmo.adapter.in.model.request.SalesRequest;
import com.aa.algoritmo.domain.model.Sales;

import java.util.List;

public interface SalesUseCase {
    List<Sales> findAllSales(Integer limit);
    Sales createSales(SalesRequest salesRequest);
    Sales updateSales(Integer id, SalesRequest salesRequest);
    void deleteSalest(Integer id);
}

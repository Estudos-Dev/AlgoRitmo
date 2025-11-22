package com.aa.algoritmo.adapter.out.persistence;

import com.aa.algoritmo.adapter.in.model.request.SalesRequest;
import com.aa.algoritmo.adapter.out.persistence.entity.SalesEntity;
import com.aa.algoritmo.adapter.out.persistence.repository.SalesRepository;
import com.aa.algoritmo.ports.out.persistence.SalesPersistencePort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalesPersistenceAdapter implements SalesPersistencePort {

    private final SalesRepository salesRepository;

    public SalesPersistenceAdapter(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @Override
    public List<SalesEntity> findAllSales(Integer limit) {
        return salesRepository.findAllLimited(limit);
    }

    @Override
    public SalesEntity createSale(SalesEntity salesEntity) {
        return salesRepository.save(salesEntity);
    }

    @Override
    public SalesEntity updateSale(Integer id, SalesRequest salesRequest) {
        return salesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Venda não encontrada com id: " + id));
    }

    @Override
    public void deleteSale(Integer id) {
        SalesEntity entity = salesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Venda não encontrada com id: " + id));
        salesRepository.delete(entity);
    }
}

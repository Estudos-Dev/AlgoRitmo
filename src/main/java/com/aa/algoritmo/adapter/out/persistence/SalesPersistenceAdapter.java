package com.aa.algoritmo.adapter.out.persistence;

import com.aa.algoritmo.adapter.in.model.SaleItemProjection;
import com.aa.algoritmo.adapter.in.model.SaleProjection;
import com.aa.algoritmo.adapter.in.model.request.SalesRequest;
import com.aa.algoritmo.adapter.out.persistence.entity.ProductEntity;
import com.aa.algoritmo.adapter.out.persistence.entity.SalesEntity;
import com.aa.algoritmo.adapter.out.persistence.repository.ItemRepository;
import com.aa.algoritmo.adapter.out.persistence.repository.SalesRepository;
import com.aa.algoritmo.adapter.service.mapper.SalesMapper;
import com.aa.algoritmo.domain.model.Sales;
import com.aa.algoritmo.domain.model.SalesItem;
import com.aa.algoritmo.ports.out.persistence.SalesPersistencePort;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class SalesPersistenceAdapter implements SalesPersistencePort {

    private final SalesRepository salesRepository;
    private final ItemRepository itemRepository;
    private final SalesMapper salesMapper;

    public SalesPersistenceAdapter(SalesRepository salesRepository, ItemRepository itemRepository, SalesMapper salesMapper) {
        this.salesRepository = salesRepository;
        this.itemRepository = itemRepository;
        this.salesMapper = salesMapper;
    }

    @Override
    public List<Sales> findAllSales(Integer limit) {

        List<SaleProjection> sales = salesRepository.findLimited(PageRequest.of(0, limit));

        List<Integer> saleIds = sales.stream()
                .map(SaleProjection::getId)
                .toList();

        List<SaleItemProjection> items = itemRepository.findItemsForSales(saleIds);

        Map<Integer, List<SalesItem>> itemsGrouped = items.stream()
                .collect(Collectors.groupingBy(
                        SaleItemProjection::getSaleId,
                        Collectors.mapping(i -> new SalesItem(
                                i.getId(),
                                i.getProductId(),
                                i.getProductName(),
                                i.getQuantity(),
                                i.getPrice()
                        ), Collectors.toList())
                ));

        return sales.stream().map(s -> new Sales(
                s.getId(),
                s.getSellerId(),
                s.getSellerName(),
                s.getClientId(),
                s.getClientName(),
                s.getCreatedAt(),
                itemsGrouped.getOrDefault(s.getId(), List.of()),
                s.getTotal()
        )).toList();
    }

    @Override
    @Transactional
    public SalesEntity createSale(SalesEntity salesEntity) {
        return salesRepository.save(salesEntity);
    }

    @Override
    @Transactional
    public SalesEntity updateSale(Integer id, SalesRequest salesRequest) {
        SalesEntity entity = salesRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Produto não encontrado"));
        salesMapper.updateEntityFromRequest(salesRequest, entity);
        return salesRepository.save(entity);
    }

    @Override
    @Transactional
    public void deleteSale(Integer id) {
        SalesEntity entity = salesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Venda não encontrada com id: " + id));
        salesRepository.delete(entity);
    }
}
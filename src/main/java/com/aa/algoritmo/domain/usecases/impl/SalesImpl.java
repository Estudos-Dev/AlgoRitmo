package com.aa.algoritmo.domain.usecases.impl;

import com.aa.algoritmo.adapter.in.model.request.SalesRequest;
import com.aa.algoritmo.adapter.out.persistence.entity.*;
import com.aa.algoritmo.adapter.service.mapper.SalesMapper;
import com.aa.algoritmo.domain.model.Sales;
import com.aa.algoritmo.domain.usecases.SalesUseCase;
import com.aa.algoritmo.ports.out.persistence.ClientPersistencePort;
import com.aa.algoritmo.ports.out.persistence.ProductPersistencePort;
import com.aa.algoritmo.ports.out.persistence.SalesPersistencePort;
import com.aa.algoritmo.ports.out.persistence.SellerPersistencePort;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesImpl implements SalesUseCase {
    private final SalesMapper salesMapper = Mappers.getMapper(SalesMapper.class);
    private final SalesPersistencePort salesPersistencePort;
    private final SellerPersistencePort sellerPersistencePort;
    private final ClientPersistencePort clientPersistencePort;
    private final ProductPersistencePort productPersistencePort;

    public SalesImpl(SalesPersistencePort salesPersistencePort, SellerPersistencePort sellerPersistencePort, ClientPersistencePort clientPersistencePort, ProductPersistencePort productPersistencePort){
        this.salesPersistencePort = salesPersistencePort;
        this.sellerPersistencePort = sellerPersistencePort;
        this.clientPersistencePort = clientPersistencePort;
        this.productPersistencePort = productPersistencePort;
    }

    @Override
    public List<Sales> findAllSales() {
        return salesMapper.toModelList(salesPersistencePort.findAllProducts());
    }

    @Override
    public Sales createSales(SalesRequest salesRequest) {
        SalesEntity sale = salesMapper.requestToEntity(salesRequest);

        SellerEntity seller = sellerPersistencePort.findById(salesRequest.sellerId());
        ClientEntity client = clientPersistencePort.findById(salesRequest.clientId());

        sale.setSeller(seller);
        sale.setClient(client);

        List<SalesItemEntity> items = salesRequest.items().stream().map(itemReq -> {
            ProductEntity product = productPersistencePort.findById(itemReq.productId());

            SalesItemEntity item = new SalesItemEntity();
            item.setSale(sale);
            item.setProduct(product);
            item.setQuantity(itemReq.quantity());
            item.setPrice(itemReq.price());
            return item;
        }).toList();

        sale.setItems(items);

        SalesEntity saved = salesPersistencePort.createSales(sale);

        return salesMapper.toModel(saved);
    }

    @Override
    public Sales updateSales(Integer id, SalesRequest salesRequest) {
        return salesMapper.toModel(salesPersistencePort.updateProduct(id, salesRequest));
    }

    @Override
    public void deleteSalest(Integer id) {
        salesPersistencePort.deleteProduct(id);
    }
}
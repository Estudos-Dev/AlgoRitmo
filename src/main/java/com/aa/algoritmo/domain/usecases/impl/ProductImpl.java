package com.aa.algoritmo.domain.usecases.impl;

import com.aa.algoritmo.adapter.in.model.request.ProductRequest;
import com.aa.algoritmo.adapter.service.mapper.ProductMapper;
import com.aa.algoritmo.domain.model.product.Product;
import com.aa.algoritmo.domain.usecases.ProductUseCase;
import com.aa.algoritmo.ports.out.persistence.ProductPersistencePort;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements ProductUseCase {
    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);
    private final ProductPersistencePort productPersistencePort;

    public ProductImpl(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }

    @Override
    public List<Product> findAllProducts() {
        return productMapper.toModelList(productPersistencePort.findAllProducts());
    }

    @Override
    public Product createProduct(ProductRequest productRequest) {
        System.out.println("createProduct" + productRequest);
        return productMapper.toModel(productPersistencePort.createProduct(productRequest));
    }

    @Override
    public Product updateProduct(Integer id, ProductRequest productRequest) {
        return productMapper.toModel(productPersistencePort.updateProduct(id, productRequest));
    }

    @Override
    public void deleteProduct(Integer id) {
        productPersistencePort.deleteProduct(id);
    }
}

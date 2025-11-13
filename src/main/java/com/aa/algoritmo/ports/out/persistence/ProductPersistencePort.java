package com.aa.algoritmo.ports.out.persistence;

import com.aa.algoritmo.adapter.in.model.request.ProductRequest;
import com.aa.algoritmo.adapter.out.persistence.entity.ProductEntity;

import java.util.List;

public interface ProductPersistencePort {
    List<ProductEntity> findAllProducts();
    ProductEntity createProduct(ProductRequest productRequest);
    ProductEntity updateProduct(Integer id, ProductRequest productRequest);
    void deleteProduct(Integer id);
    ProductEntity findById(Integer id);
}

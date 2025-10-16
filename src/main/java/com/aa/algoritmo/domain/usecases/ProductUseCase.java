package com.aa.algoritmo.domain.usecases;

import com.aa.algoritmo.adapter.in.model.request.ProductRequest;
import com.aa.algoritmo.domain.model.product.Product;

import java.util.List;

public interface ProductUseCase {
    List<Product> findAllProducts();
    Product createProduct(ProductRequest productRequest);
    Product updateProduct(Integer id, ProductRequest productRequest);
    void deleteProduct(Integer id);
}

package com.aa.algoritmo.adapter.service.mapper;

import com.aa.algoritmo.adapter.in.model.request.ProductRequest;
import com.aa.algoritmo.adapter.in.model.response.ProductResponse;
import com.aa.algoritmo.adapter.out.persistence.entity.ProductEntity;
import com.aa.algoritmo.domain.model.product.Product;

import java.util.List;

public interface ProductMapper {
    ProductEntity requestToEntity(ProductRequest productRequest);

    Product toModel(ProductEntity productEntity);

    List<Product> toModelList(List<ProductEntity> productEntityList);

    ProductResponse toResponse(Product product);

    List<ProductResponse> toResponseList(List<Product> productList);
}

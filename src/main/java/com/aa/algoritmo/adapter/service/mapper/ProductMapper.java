package com.aa.algoritmo.adapter.service.mapper;

import com.aa.algoritmo.adapter.in.model.request.ProductRequest;
import com.aa.algoritmo.adapter.in.model.response.ProductResponse;
import com.aa.algoritmo.adapter.out.persistence.entity.ProductEntity;
import com.aa.algoritmo.domain.model.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    ProductEntity requestToEntity(ProductRequest productRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateEntityFromRequest(ProductRequest productRequest, @MappingTarget ProductEntity entity);

    Product toModel(ProductEntity productEntity);

    List<Product> toModelList(List<ProductEntity> productEntityList);

    ProductResponse toResponse(Product product);

    List<ProductResponse> toResponseList(List<Product> productList);
}
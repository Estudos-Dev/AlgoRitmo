package com.aa.algoritmo.adapter.service.mapper;

import com.aa.algoritmo.adapter.in.model.response.SalesItemResponse;
import com.aa.algoritmo.adapter.out.persistence.entity.SalesItemEntity;
import com.aa.algoritmo.domain.model.SalesItem;
import org.mapstruct.Mapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalesItemMapper {

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "productName", source = "product.name")
    SalesItem toModel(SalesItemEntity salesItemEntity);

    List<SalesItem> toModelList(List<SalesItemEntity> list);

    SalesItemResponse toResponse(SalesItem salesItem);

    List<SalesItemResponse> toResponseList(List<SalesItem> salesItems);
}
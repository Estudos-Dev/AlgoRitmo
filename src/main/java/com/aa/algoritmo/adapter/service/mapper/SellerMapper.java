package com.aa.algoritmo.adapter.service.mapper;

import com.aa.algoritmo.adapter.in.model.request.SellerRequest;

import com.aa.algoritmo.adapter.in.model.response.SellerResponse;
import com.aa.algoritmo.adapter.out.persistence.entity.SellerEntity;
import com.aa.algoritmo.domain.model.vendedor.Seller;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SellerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    SellerEntity requestToEntity(SellerRequest sellerRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateEntityFromRequest(SellerRequest sellerRequest, @MappingTarget SellerEntity entity);

    Seller toModel(SellerEntity sellerEntity);

    List<Seller> toModelList(List<SellerEntity> sellerEntityList);

    SellerResponse toResponse(Seller seller);

    List<SellerResponse> toResponseList(List<Seller> sellerList);
}
package com.aa.algoritmo.adapter.service.mapper;

import com.aa.algoritmo.adapter.in.model.request.SalesRequest;
import com.aa.algoritmo.adapter.in.model.response.SalesResponse;
import com.aa.algoritmo.adapter.out.persistence.entity.SalesEntity;
import com.aa.algoritmo.domain.model.Sales;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalesMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    SalesEntity requestToEntity(SalesRequest salesRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateEntityFromRequest(SalesRequest salesRequest, @MappingTarget SalesEntity entity);

    Sales toModel(SalesEntity salesEntity);

    List<Sales> toModelList(List<SalesEntity> salesEntity);

    SalesResponse toResponse(Sales sales);

    List<SalesResponse> toResponseList(List<Sales> salesList);

}
package com.aa.algoritmo.adapter.service.mapper;

import com.aa.algoritmo.adapter.in.model.request.SalesRequest;
import com.aa.algoritmo.adapter.in.model.response.SalesResponse;
import com.aa.algoritmo.adapter.out.persistence.entity.SalesEntity;
import com.aa.algoritmo.adapter.out.persistence.entity.SalesItemEntity;
import com.aa.algoritmo.domain.model.Sales;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring", uses = {SalesItemMapper.class})
public interface SalesMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    SalesEntity requestToEntity(SalesRequest salesRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateEntityFromRequest(SalesRequest salesRequest, @MappingTarget SalesEntity entity);

    @Mapping(target = "sellerId", source = "seller.id")
    @Mapping(target = "sellerName", source = "seller.name")
    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "clientName", source = "client.name")
    @Mapping(target = "date", source = "createdAt")
    @Mapping(target = "total", expression = "java(calculateTotal(salesEntity.getItems()))")
    Sales toModel(SalesEntity salesEntity);

    List<Sales> toModelList(List<Sales> Sales);

    SalesResponse toResponse(Sales sales);

    List<SalesResponse> toResponseList(List<Sales> salesList);

    default BigDecimal calculateTotal(List<SalesItemEntity> items) {
        if (items == null || items.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return items.stream()
                .map(item -> BigDecimal.valueOf(item.getPrice())
                        .multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
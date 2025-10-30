package com.aa.algoritmo.adapter.service.mapper;

import com.aa.algoritmo.adapter.in.model.request.SellerRequest;
import com.aa.algoritmo.adapter.in.model.response.SellerResponse;
import com.aa.algoritmo.adapter.out.persistence.entity.SellerEntity;
import com.aa.algoritmo.domain.model.vendedor.Seller;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SellerMapper {

    SellerEntity requestToEntity(SellerRequest sellerRequest);

    Seller toModel(SellerEntity sellerEntity);

    SellerResponse toResponse(Seller seller);
}

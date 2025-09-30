package com.aa.algoritmo.adapter.service.mapper;

import com.aa.algoritmo.adapter.in.model.request.VendedorRequest;
import com.aa.algoritmo.adapter.in.model.response.VendedorResponse;
import com.aa.algoritmo.adapter.out.persistence.entity.VendedorEntity;
import com.aa.algoritmo.domain.model.vendedor.Vendedor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VendedorMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(target = "criadoEm", ignore = true)
    VendedorEntity requestToEntity(VendedorRequest vendedorRequest);
    Vendedor toModel(VendedorEntity userEntity);
    VendedorResponse toResponse(Vendedor vendedor);
}

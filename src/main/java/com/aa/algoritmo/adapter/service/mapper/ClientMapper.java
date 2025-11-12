package com.aa.algoritmo.adapter.service.mapper;

import com.aa.algoritmo.adapter.in.model.request.ClientRequest;
import com.aa.algoritmo.adapter.in.model.response.ClientResponse;
import com.aa.algoritmo.adapter.out.persistence.entity.ClientEntity;
import com.aa.algoritmo.domain.model.client.Client;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    ClientEntity requestToEntity(ClientRequest clientRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateEntityFromRequest(ClientRequest clientRequest, @MappingTarget ClientEntity entity);

    Client toModel(ClientEntity clientEntity);

    List<Client> toModelList(List<ClientEntity> clientEntityList);

    ClientResponse toResponse(Client client);

    List<ClientResponse> toResponseList(List<Client> clientList);
}


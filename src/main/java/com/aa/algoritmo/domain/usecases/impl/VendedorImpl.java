package com.aa.algoritmo.domain.usecases.impl;

import com.aa.algoritmo.adapter.in.model.request.VendedorRequest;
import com.aa.algoritmo.adapter.service.mapper.VendedorMapper;
import com.aa.algoritmo.domain.model.vendedor.Vendedor;
import com.aa.algoritmo.domain.usecases.VendedorUseCase;
import com.aa.algoritmo.ports.out.persistence.VendedorPersistencePort;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VendedorImpl implements VendedorUseCase {
    private final VendedorMapper vendedorMapper = Mappers.getMapper(VendedorMapper.class);
    private final VendedorPersistencePort vendedorPersistencePort;

    public VendedorImpl(VendedorPersistencePort vendedorPersistencePort) {
        this.vendedorPersistencePort = vendedorPersistencePort;
    }

    @Override
    public Vendedor createUser(VendedorRequest vendedorRequest) {
        return vendedorMapper.toModel(vendedorPersistencePort.createUser(vendedorRequest));
    }

    @Override
    public Vendedor getById(UUID id) {
        return vendedorMapper.toModel(vendedorPersistencePort.findById(id));
    }


}

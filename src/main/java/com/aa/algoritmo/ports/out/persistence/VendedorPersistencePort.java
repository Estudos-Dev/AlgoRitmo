package com.aa.algoritmo.ports.out.persistence;

import com.aa.algoritmo.adapter.in.model.request.VendedorRequest;
import com.aa.algoritmo.adapter.out.persistence.entity.VendedorEntity;

import java.util.UUID;

public interface VendedorPersistencePort {
    VendedorEntity findById(UUID id);

    VendedorEntity createUser(VendedorRequest vendedorRequest);
}

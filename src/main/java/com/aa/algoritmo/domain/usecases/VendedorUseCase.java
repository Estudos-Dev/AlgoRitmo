package com.aa.algoritmo.domain.usecases;

import com.aa.algoritmo.adapter.in.model.request.VendedorRequest;
import com.aa.algoritmo.domain.model.vendedor.Vendedor;

import java.util.UUID;

public interface VendedorUseCase {
    Vendedor getById(UUID id);

    Vendedor createUser(VendedorRequest vendedorRequest);
}

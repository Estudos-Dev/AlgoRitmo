package com.aa.algoritmo.adapter.out.persistence;

import com.aa.algoritmo.adapter.in.model.request.VendedorRequest;
import com.aa.algoritmo.adapter.out.persistence.entity.VendedorEntity;
import com.aa.algoritmo.adapter.out.persistence.repository.VendedorRepository;
import com.aa.algoritmo.adapter.service.mapper.VendedorMapper;
import com.aa.algoritmo.ports.out.persistence.VendedorPersistencePort;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class VendedorPersistenceAdapter implements VendedorPersistencePort {
    private VendedorMapper vendedorMapper = Mappers.getMapper(VendedorMapper.class);
    private final VendedorRepository vendedorRepository;

    public VendedorPersistenceAdapter(VendedorRepository vendedorRepository, VendedorMapper vendedorMapper) {
        this.vendedorRepository = vendedorRepository;
        this.vendedorMapper = vendedorMapper;
    }

    @Override
    public VendedorEntity createUser(VendedorRequest vendedorRequest) {
        VendedorEntity entity = vendedorMapper.requestToEntity(vendedorRequest);

        return vendedorRepository.save(entity);
    }

    @Override
    public VendedorEntity findById(UUID id) {
        return vendedorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
    }


}

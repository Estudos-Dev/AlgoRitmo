package com.aa.algoritmo.adapter.out.persistence;

import com.aa.algoritmo.adapter.in.model.request.SellerRequest;
import com.aa.algoritmo.adapter.out.persistence.entity.SellerEntity;
import com.aa.algoritmo.adapter.out.persistence.repository.SellerRepository;
import com.aa.algoritmo.adapter.service.mapper.SellerMapper;
import com.aa.algoritmo.ports.out.persistence.SellerPersistencePort;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public class SellerPersistenceAdapter implements SellerPersistencePort {
    private SellerMapper sellerMapper = Mappers.getMapper(SellerMapper.class);
    private final SellerRepository sellerRepository;

    public SellerPersistenceAdapter(SellerRepository sellerRepository, SellerMapper sellerMapper) {
        this.sellerRepository = sellerRepository;
        this.sellerMapper = sellerMapper;
    }

    @Override
    public SellerEntity createUser(SellerRequest sellerRequest) {
        SellerEntity entity = sellerMapper.requestToEntity(sellerRequest);

        return sellerRepository.save(entity);
    }

    @Override
    public void deleteUserById(int id) {
        sellerRepository.deleteById(id);
    }

    @Override
    public SellerEntity findById(int id) {
        return sellerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
    }
}
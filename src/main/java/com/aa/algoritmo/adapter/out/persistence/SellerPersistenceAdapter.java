package com.aa.algoritmo.adapter.out.persistence;

import com.aa.algoritmo.adapter.in.model.request.SellerRequest;
import com.aa.algoritmo.adapter.out.persistence.entity.SellerEntity;
import com.aa.algoritmo.adapter.out.persistence.repository.SellerRepository;
import com.aa.algoritmo.adapter.service.mapper.SellerMapper;
import com.aa.algoritmo.ports.out.persistence.SellerPersistencePort;
import jakarta.transaction.Transactional;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SellerPersistenceAdapter implements SellerPersistencePort {
    private SellerMapper sellerMapper = Mappers.getMapper(SellerMapper.class);
    private final SellerRepository sellerRepository;

    public SellerPersistenceAdapter(SellerRepository sellerRepository, SellerMapper sellerMapper) {
        this.sellerRepository = sellerRepository;
        this.sellerMapper = sellerMapper;
    }

    public List<SellerEntity> findAllSellers(Integer limit) {
        return sellerRepository.findAllLimited(limit);
    }

    @Override
    public SellerEntity createUser(SellerRequest sellerRequest) {
        SellerEntity entity = sellerMapper.requestToEntity(sellerRequest);

        return sellerRepository.save(entity);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        sellerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public SellerEntity updateSeller(Integer id, SellerRequest sellerRequest) {
        SellerEntity entity = sellerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Produto não encontrado"));
        sellerMapper.updateEntityFromRequest(sellerRequest, entity);
        return sellerRepository.save(entity);
    }

    @Override
    public SellerEntity findById(int id) {
        return sellerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
    }
}
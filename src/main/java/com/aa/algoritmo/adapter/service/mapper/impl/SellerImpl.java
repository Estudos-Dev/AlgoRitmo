package com.aa.algoritmo.adapter.service.mapper.impl;

import com.aa.algoritmo.adapter.in.model.request.SellerRequest;
import com.aa.algoritmo.adapter.service.mapper.SellerMapper;
import com.aa.algoritmo.domain.model.vendedor.Seller;
import com.aa.algoritmo.domain.usecases.SellerUseCase;
import com.aa.algoritmo.ports.out.persistence.SellerPersistencePort;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerImpl implements SellerUseCase {
    private final SellerMapper sellerMapper = Mappers.getMapper(SellerMapper.class);
    private final SellerPersistencePort sellerPersistencePort;

    public SellerImpl(SellerPersistencePort sellerPersistencePort) {
        this.sellerPersistencePort = sellerPersistencePort;
    }

    @Override
    public List<Seller> findAllSellers() {
        return sellerMapper.toModelList(sellerPersistencePort.findAllSellers());
    }

    @Override
    public Seller createUser(SellerRequest sellerRequest) {
        return sellerMapper.toModel(sellerPersistencePort.createUser(sellerRequest));
    }

    @Override
    public void deleteUserById(int id) {
       sellerPersistencePort.deleteUserById(id);
    }

    @Override
    public Seller updateSeller(Integer id, SellerRequest sellerRequest) {
        return sellerMapper.toModel(sellerPersistencePort.updateSeller(id, sellerRequest));

    }

    @Override
    public Seller findById(int id) {
        return sellerMapper.toModel(sellerPersistencePort.findById(id));
    }
}
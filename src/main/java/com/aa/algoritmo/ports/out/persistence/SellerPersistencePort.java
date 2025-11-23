package com.aa.algoritmo.ports.out.persistence;

import com.aa.algoritmo.adapter.in.model.request.SellerRequest;
import com.aa.algoritmo.adapter.out.persistence.entity.SellerEntity;

import java.util.List;

public interface SellerPersistencePort {
    List<SellerEntity> findAllSellers(Integer limit);

    SellerEntity findById(int id);

    SellerEntity createUser(SellerRequest sellerRequest);

    void deleteUserById(int id);

    SellerEntity updateSeller(Integer id, SellerRequest sellerRequest);
}

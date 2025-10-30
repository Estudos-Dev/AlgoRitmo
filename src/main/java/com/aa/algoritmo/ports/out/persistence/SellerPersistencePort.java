package com.aa.algoritmo.ports.out.persistence;

import com.aa.algoritmo.adapter.in.model.request.SellerRequest;
import com.aa.algoritmo.adapter.out.persistence.entity.SellerEntity;

public interface SellerPersistencePort {
    SellerEntity findById(int id);

    SellerEntity createUser(SellerRequest sellerRequest);

    void deleteUserById(int id);
}

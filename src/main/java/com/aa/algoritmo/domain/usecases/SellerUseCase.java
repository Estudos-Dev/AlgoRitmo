package com.aa.algoritmo.domain.usecases;

import com.aa.algoritmo.adapter.in.model.request.SellerRequest;
import com.aa.algoritmo.domain.model.vendedor.Seller;

public interface SellerUseCase {
    Seller getById(int id);

    Seller createUser(SellerRequest sellerRequest);

    void deleteUserById(int id);
}

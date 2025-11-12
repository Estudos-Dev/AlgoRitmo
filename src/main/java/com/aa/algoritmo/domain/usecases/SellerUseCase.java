package com.aa.algoritmo.domain.usecases;

import com.aa.algoritmo.adapter.in.model.request.SellerRequest;
import com.aa.algoritmo.domain.model.vendedor.Seller;

import java.util.List;

public interface SellerUseCase {

    List<Seller> findAllSellers();

    Seller findById(int id);

    Seller createUser(SellerRequest sellerRequest);

    void deleteUserById(int id);
}

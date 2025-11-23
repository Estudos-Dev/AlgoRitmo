package com.aa.algoritmo.adapter.in.api;

import com.aa.algoritmo.adapter.in.model.request.SellerRequest;
import com.aa.algoritmo.adapter.in.model.response.SellerResponse;
import com.aa.algoritmo.adapter.service.mapper.SellerMapper;
import com.aa.algoritmo.domain.usecases.SellerUseCase;
import com.aa.algoritmo.ports.in.api.SellerManagementPort;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SellerApiController implements SellerManagementPort {
    private final SellerMapper sellerMapper = Mappers.getMapper(SellerMapper.class);
    private final SellerUseCase sellerUseCase;

    public SellerApiController(SellerUseCase sellerUseCase) {
        this.sellerUseCase = sellerUseCase;
    }

    @Override
    public ResponseEntity<SellerResponse> createUser(SellerRequest sellerRequest) {
        return ResponseEntity.ok(sellerMapper.toResponse(sellerUseCase.createUser(sellerRequest)));
    }

    public ResponseEntity<List<SellerResponse>> findAllSellers() {
        return ResponseEntity.ok(sellerMapper.toResponseList(sellerUseCase.findAllSellers()));
    }

    @Override
    public void deleteUserById(int id) {
        try {
            sellerUseCase.deleteUserById(id);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public ResponseEntity<SellerResponse> getUserById(int id) {
        try{
            return ResponseEntity.ok(sellerMapper.toResponse(sellerUseCase.findById(id)));
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public ResponseEntity<SellerResponse> updateClient(Integer id, SellerRequest sellerRequest) {
        return ResponseEntity.ok(sellerMapper.toResponse(sellerUseCase.updateSeller(id, sellerRequest)));

    }
}

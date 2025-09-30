package com.aa.algoritmo.adapter.in.api;

import com.aa.algoritmo.adapter.in.model.request.VendedorRequest;
import com.aa.algoritmo.adapter.in.model.response.VendedorResponse;
import com.aa.algoritmo.adapter.service.mapper.VendedorMapper;
import com.aa.algoritmo.domain.usecases.VendedorUseCase;
import com.aa.algoritmo.ports.in.api.VendedorManagementPort;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class VendedorApiController implements VendedorManagementPort {
    private final VendedorMapper vendedorMapper = Mappers.getMapper(VendedorMapper.class);
    private final VendedorUseCase vendedorUseCase;

    public VendedorApiController(VendedorUseCase vendedorUseCase) {
        this.vendedorUseCase = vendedorUseCase;
    }

    @Override
    public ResponseEntity<VendedorResponse> createUser(VendedorRequest vendedorRequest) {
        return ResponseEntity.ok(vendedorMapper.toResponse(vendedorUseCase.createUser(vendedorRequest)));
    }

    @Override
    public ResponseEntity<VendedorResponse> getUserById(UUID id) {
        try{
            return ResponseEntity.ok(vendedorMapper.toResponse(vendedorUseCase.getById(id)));
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

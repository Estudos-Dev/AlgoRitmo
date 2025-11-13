package com.aa.algoritmo.adapter.in.api;

import com.aa.algoritmo.adapter.in.model.request.SalesRequest;
import com.aa.algoritmo.adapter.in.model.response.SalesResponse;
import com.aa.algoritmo.adapter.service.mapper.SalesMapper;
import com.aa.algoritmo.domain.usecases.SalesUseCase;
import com.aa.algoritmo.ports.in.api.SalesManagementPort;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalesApiController implements SalesManagementPort {
    private final SalesMapper salesMapper = Mappers.getMapper(SalesMapper.class);
    private final SalesUseCase salesUseCase;

    public SalesApiController(SalesUseCase salesUseCase) {
        this.salesUseCase = salesUseCase;
    }

    @Override
    public ResponseEntity<List<SalesResponse>> findAllSales() {
        return ResponseEntity.ok(salesMapper.toResponseList(salesUseCase.findAllSales()));
    }

    @Override
    public ResponseEntity<SalesResponse> createSales(SalesRequest salesRequest) {
        return ResponseEntity.ok(salesMapper.toResponse(salesUseCase.createSales(salesRequest)));
    }

    @Override
    public ResponseEntity<SalesResponse> updateSales(Integer id, SalesRequest salesRequest) {
        return ResponseEntity.ok(salesMapper.toResponse(salesUseCase.updateSales(id, salesRequest)));
    }

    @Override
    public ResponseEntity<Void> deleteSale(Integer id) {
        salesUseCase.deleteSalest(id);
        return ResponseEntity.ok().build();
    }
}
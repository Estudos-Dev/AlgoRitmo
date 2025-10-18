package com.aa.algoritmo.adapter.in.api;

import com.aa.algoritmo.adapter.in.model.request.ProductRequest;
import com.aa.algoritmo.adapter.in.model.response.ProductResponse;
import com.aa.algoritmo.adapter.service.mapper.ProductMapper;
import com.aa.algoritmo.domain.usecases.ProductUseCase;
import com.aa.algoritmo.ports.in.api.ProductManagementPort;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductApiController implements ProductManagementPort {
    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);
    private final ProductUseCase productUseCase;

    public ProductApiController(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @Override
    public ResponseEntity<List<ProductResponse>> findAllProducts() {
        return ResponseEntity.ok(productMapper.toResponseList(productUseCase.findAllProducts()));
    }

    @Override
    public ResponseEntity<ProductResponse> createProduct(ProductRequest productRequest) {

        return ResponseEntity.ok(productMapper.toResponse(productUseCase.createProduct(productRequest)));
    }

    @Override
    public ResponseEntity<ProductResponse> updateProduct(Integer id, ProductRequest productRequest) {
        return ResponseEntity.ok(productMapper.toResponse(productUseCase.updateProduct(id, productRequest)));
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Integer id) {
        productUseCase.deleteProduct(id);
       return ResponseEntity.ok().build();
    }
}

package com.aa.algoritmo.adapter.out.persistence;

import com.aa.algoritmo.adapter.in.model.request.ProductRequest;
import com.aa.algoritmo.adapter.out.persistence.entity.ProductEntity;
import com.aa.algoritmo.adapter.out.persistence.repository.ProductRepository;
import com.aa.algoritmo.adapter.service.mapper.ProductMapper;
import com.aa.algoritmo.ports.out.persistence.ProductPersistencePort;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductPersistenceAdapter implements ProductPersistencePort {
    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);
    private final ProductRepository productRepository;

    public ProductPersistenceAdapter(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductEntity> findAllProducts() {
            return productRepository.findAll();
    }

    @Override
    public ProductEntity createProduct(ProductRequest productRequest) {
        ProductEntity entity = productMapper.requestToEntity(productRequest);
        System.out.println("createProduct" + productRequest + entity);
        return productRepository.save(entity);
    }

    @Override
    public ProductEntity  updateProduct(Integer id, ProductRequest productRequest) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Produto não encontrado"));
        // Atualiza a entidade existente usando @MappingTarget
        productMapper.updateEntityFromRequest(productRequest, entity);
        return productRepository.save(entity);
    }

    @Override
    public void deleteProduct(Integer id) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Produto não encontrado"));

        productRepository.delete(entity);
    }

    @Override
    public ProductEntity findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com id: " + id));
    }
}
package com.aa.algoritmo.adapter.out.persistence.repository;

import com.aa.algoritmo.adapter.out.persistence.entity.ClientEntity;
import com.aa.algoritmo.adapter.out.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
    @Query(value = "SELECT * FROM clients LIMIT :limit", nativeQuery = true)
    List<ClientEntity> findAllLimited(Integer limit);
}
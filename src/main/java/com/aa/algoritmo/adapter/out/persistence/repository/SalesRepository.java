package com.aa.algoritmo.adapter.out.persistence.repository;

import com.aa.algoritmo.adapter.out.persistence.entity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<SalesEntity, Integer> {
}
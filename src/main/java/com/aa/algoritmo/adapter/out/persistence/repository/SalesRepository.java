package com.aa.algoritmo.adapter.out.persistence.repository;

import com.aa.algoritmo.adapter.out.persistence.entity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalesRepository extends JpaRepository<SalesEntity, Integer> {
    @Query(value = "SELECT * FROM sales LIMIT :limit", nativeQuery = true)
    List<SalesEntity> findAllLimited(@Param("limit") int limit);
}
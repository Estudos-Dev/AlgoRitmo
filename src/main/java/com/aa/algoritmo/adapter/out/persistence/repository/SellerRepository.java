package com.aa.algoritmo.adapter.out.persistence.repository;

import com.aa.algoritmo.adapter.out.persistence.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Integer> {
    @Query(value = "SELECT * FROM sellers LIMIT :limit", nativeQuery = true)
    List<SellerEntity> findAllLimited(@Param("limit") int limit);
}

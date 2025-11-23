package com.aa.algoritmo.adapter.out.persistence.repository;

import com.aa.algoritmo.adapter.in.model.SaleProjection;
import com.aa.algoritmo.adapter.out.persistence.entity.SalesEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesRepository extends JpaRepository<SalesEntity, Integer> {
    @Query("""
    SELECT
        s.id AS id,
        seller.id AS sellerId,
        seller.name AS sellerName,
        client.id AS clientId,
        client.name AS clientName,
        s.createdAt AS createdAt,
        SUM(i.price * i.quantity) AS total
    FROM SalesEntity s
    JOIN s.seller seller
    JOIN s.client client
    LEFT JOIN s.items i
    GROUP BY s.id, seller.id, seller.name, client.id, client.name, s.createdAt
    ORDER BY s.createdAt DESC
""")
    List<SaleProjection> findLimited(Pageable pageable);
}
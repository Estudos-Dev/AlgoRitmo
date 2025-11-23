package com.aa.algoritmo.adapter.out.persistence.repository;

import com.aa.algoritmo.adapter.in.model.SaleItemProjection;
import com.aa.algoritmo.adapter.out.persistence.entity.SalesItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<SalesItemEntity, Integer> {
    @Query("""
    SELECT 
        i.id AS id,
        p.id AS productId,
        p.name AS productName,
        i.price AS price,
        i.quantity AS quantity,
        s.id AS saleId
    FROM SalesItemEntity i
    JOIN i.product p
    JOIN i.sale s
    WHERE s.id IN :saleIds
""")
    List<SaleItemProjection> findItemsForSales(List<Integer> saleIds);
}
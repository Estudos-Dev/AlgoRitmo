package com.aa.algoritmo.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "sales_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SalesItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private SalesEntity sale;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    private Integer quantity;

    private Integer price;
}

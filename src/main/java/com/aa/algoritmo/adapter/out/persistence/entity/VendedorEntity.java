package com.aa.algoritmo.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "vendedor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VendedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    private String email;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm = LocalDateTime.now();
}

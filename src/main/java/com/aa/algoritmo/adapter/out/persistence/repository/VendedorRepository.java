package com.aa.algoritmo.adapter.out.persistence.repository;

import com.aa.algoritmo.adapter.out.persistence.entity.VendedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorEntity, UUID> {
}

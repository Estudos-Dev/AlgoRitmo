package com.aa.algoritmo.adapter.out.persistence.repository;

import com.aa.algoritmo.adapter.out.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    @Query("SELECT user FROM UserEntity user WHERE user.id = :id")
    Optional<UserEntity> findById(UUID id);

    UUID id(UUID id);
}

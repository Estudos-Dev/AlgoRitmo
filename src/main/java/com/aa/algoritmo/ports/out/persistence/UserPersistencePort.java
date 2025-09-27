package com.aa.algoritmo.ports.out.persistence;

import com.aa.algoritmo.adapter.out.persistence.entity.UserEntity;

import java.util.UUID;

public interface UserPersistencePort {
    UserEntity findById(UUID id);
}

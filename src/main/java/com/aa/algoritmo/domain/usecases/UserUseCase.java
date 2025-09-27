package com.aa.algoritmo.domain.usecases;

import com.aa.algoritmo.domain.model.user.User;

import java.util.UUID;

public interface UserUseCase {
    User getById(UUID id);
}

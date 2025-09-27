package com.aa.algoritmo.domain.usecases.impl;

import com.aa.algoritmo.adapter.service.mapper.UserMapper;
import com.aa.algoritmo.domain.model.user.User;
import com.aa.algoritmo.domain.usecases.UserUseCase;
import com.aa.algoritmo.ports.out.persistence.UserPersistencePort;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserImpl implements UserUseCase {
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private final UserPersistencePort userPersistencePort;

    public UserImpl(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public User getById(UUID id) {
        return userMapper.toModel(userPersistencePort.findById(id));
    }
}

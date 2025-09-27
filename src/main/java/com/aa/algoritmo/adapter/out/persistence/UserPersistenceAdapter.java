package com.aa.algoritmo.adapter.out.persistence;

import com.aa.algoritmo.adapter.out.persistence.entity.UserEntity;
import com.aa.algoritmo.adapter.out.persistence.repository.UserRepository;
import com.aa.algoritmo.ports.out.persistence.UserPersistencePort;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserPersistenceAdapter implements UserPersistencePort {
    private final UserRepository userRepository;

    public UserPersistenceAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity findById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
    }
}

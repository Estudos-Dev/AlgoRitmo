package com.aa.algoritmo.adapter.in.api;

import com.aa.algoritmo.adapter.in.model.response.UserResponse;
import com.aa.algoritmo.adapter.service.mapper.UserMapper;
import com.aa.algoritmo.domain.usecases.UserUseCase;
import com.aa.algoritmo.ports.in.api.UserManagementPort;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserApiController implements UserManagementPort {
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private final UserUseCase userUseCase;

    public UserApiController( UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @Override
    public ResponseEntity<UserResponse> getUserById(UUID id) {
        try{
            return ResponseEntity.ok(userMapper.toResponse(userUseCase.getById(id)));
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

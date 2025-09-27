package com.aa.algoritmo.adapter.service.mapper;

import com.aa.algoritmo.adapter.in.model.response.UserResponse;
import com.aa.algoritmo.adapter.out.persistence.entity.UserEntity;
import com.aa.algoritmo.domain.model.user.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserEntity toEntity(User user);
    User toModel(UserEntity userEntity);
    UserResponse toResponse(User user);
}

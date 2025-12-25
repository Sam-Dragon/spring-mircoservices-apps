package com.learning.microservices.users.mappers;

import com.learning.microservices.users.entity.Users;
import com.learning.microservices.users.model.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    Users toEntity(UserResponse dto);

    UserResponse toDto(Users entity);
}

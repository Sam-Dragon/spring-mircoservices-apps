package com.learning.microservices.users.mappers;

import com.learning.microservices.users.entity.Users;
import com.learning.microservices.users.model.UserRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {

    Users toEntity(UserRequest dto);

    UserRequest toDto(Users entity);
}

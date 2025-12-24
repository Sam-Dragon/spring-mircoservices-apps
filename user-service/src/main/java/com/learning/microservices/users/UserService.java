package com.learning.microservices.users;

import com.learning.microservices.users.model.UserRequest;
import com.learning.microservices.users.model.UserResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface UserService {

    List<UserResponse> findAll();

    Optional<UserResponse> findById(String userId);

    UserResponse create(UserRequest userRequest);

    Optional<UserResponse> update(String userId, UserRequest userRequest);

    Optional<UserResponse> delete(String userId);
}

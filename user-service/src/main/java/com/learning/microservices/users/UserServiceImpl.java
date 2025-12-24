package com.learning.microservices.users;

import com.learning.microservices.users.model.UserRequest;
import com.learning.microservices.users.model.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<UserResponse> findAll() {
        return Stream.of(new UserResponse())
                     .toList();
    }

    @Override
    public Optional<UserResponse> findById(String userId) {
        return Optional.empty();
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        return null;
    }

    @Override
    public Optional<UserResponse> update(String userId, UserRequest userRequest) {
        return Optional.empty();
    }

    @Override
    public Optional<UserResponse> delete(String userId) {
        return Optional.empty();
    }
}

package com.learning.microservices.users;

import com.learning.microservices.users.entity.Users;
import com.learning.microservices.users.mappers.UserRequestMapper;
import com.learning.microservices.users.mappers.UserResponseMapper;
import com.learning.microservices.users.model.NotificationResponse;
import com.learning.microservices.users.model.UserRequest;
import com.learning.microservices.users.model.UserResponse;
import com.learning.microservices.users.notifications.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;


    @Transactional(readOnly = true)
    @Override
    public List<UserResponse> findAll() {

        return repository.getAll()
                         .map(userResponseMapper::toDto)
                         .toList();
    }

    @Override
    public Optional<UserResponse> findById(String userId) {

        return repository.findById(userId)
                         .map(userResponseMapper::toDto);
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        // Convert Request Model to User Entity
        Users user = userRequestMapper.toEntity(userRequest);

        repository.save(user);

        // Convert User Entity to Response Model
        return userResponseMapper.toDto(user);
    }

    @Override
    public Optional<UserResponse> update(String userId, UserRequest userRequest) {

        return repository.findById(userId)
                         .map(u -> {
                             Users user = userRequestMapper.toEntity(userRequest);
                             user.setId(userId);
                             return user;
                         })
                         .map(repository::save)
                         .map(userResponseMapper::toDto);
    }

    @Override
    public Optional<UserResponse> delete(String userId) {

        return repository.findById(userId)
                         .map(u -> {
                             repository.delete(u);
                             return userResponseMapper.toDto(u);
                         });
    }

    /* SETTER BASED INJECTION */
    // Optional dependency
    private NotificationService notificationService;

    @Autowired(required = false)
    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public NotificationResponse notify(String userId) {

        NotificationResponse response = new NotificationResponse();
        response.setId(userId);
        response.setMessage("Failed");
        response.setExecutionTime(LocalDateTime.now());

        return Optional.ofNullable(notificationService)
                       .map(e -> {
                           e.notifyUser();
                           response.setMessage("Success");
                           return response;
                       })
                       .orElseGet(() -> response);
    }
}

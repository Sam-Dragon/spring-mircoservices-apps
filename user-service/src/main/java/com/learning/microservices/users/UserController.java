package com.learning.microservices.users;

import com.learning.microservices.users.model.NotificationResponse;
import com.learning.microservices.users.model.UserRequest;
import com.learning.microservices.users.model.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    //    @RequestMapping(value = "/{user_id}", produces = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON},
    //    method = RequestMethod.GET)
    @GetMapping(value = "/{user_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponse> findById(@PathVariable("user_id") String userId) {

        return userService.findById(userId)
                          .map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound()
                                                         .build());
    }

    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(userService.create(userRequest));
    }

    @PutMapping(value = "/{user_id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponse> update(@PathVariable("user_id") String userId,
                                               @RequestBody UserRequest userRequest) {

        return userService.update(userId, userRequest)
                          .map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound()
                                                         .build());
    }

    @DeleteMapping(value = "/{user_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponse> delete(@PathVariable("user_id") String userId) {

        return userService.delete(userId)
                          .map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound()
                                                         .build());
    }

    @GetMapping(value = "/notify/{user_id}")
    public ResponseEntity<NotificationResponse> notify(@PathVariable("user_id") String userId) {
        return ResponseEntity.ok(userService.notify(userId));
    }
}

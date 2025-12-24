package com.learning.microservices.users.model;

import lombok.Data;

@Data
public class UserResponse {

    private String name;
    private String email;
    private String mobile;
}

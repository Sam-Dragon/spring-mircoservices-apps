package com.learning.microservices.users.model;

import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private String email;
    private String mobile;
}

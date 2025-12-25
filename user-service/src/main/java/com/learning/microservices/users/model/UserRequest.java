package com.learning.microservices.users.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest {

    @NotNull(message = "first name is mandatory")
    @Size(min = 3, max = 15, message = "first name must be between 8 to 16 characters")
    private String firstname;

    @NotNull(message = "first name is mandatory")
    @Size(min = 3, max = 15, message = "first name must be between 8 to 16 characters")
    private String lastname;

    @Email(message = "email is mandatory")
    private String email;
}

package com.learning.microservices.users.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationResponse {

    private String id;
    private String message;
    private LocalDateTime executionTime;
}

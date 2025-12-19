package com.learning.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class WelcomeController {

    @Value("${spring.application.name:test-service}")
    private String application;

    @Value("${server.port:1000}")
    private String port;

    @GetMapping("/welcome")
    public String health() {
        return application + " application is up and running on port - " + port;
    }
}

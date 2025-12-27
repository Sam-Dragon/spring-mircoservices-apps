package com.learning.microservices.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Mono;


@Configuration
public class UserGlobalFilterConfig {

    private static final Logger logger = LoggerFactory.getLogger(UserGlobalFilterConfig.class);

    @Order(3)
    @Bean
    public GlobalFilter authorizationFilter() {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            logger.info("Request >> Id :: {}, Path :: {}, Header :: {}", request.getId(), request.getPath(),
                    request.getHeaders());

            long startTime = System.currentTimeMillis();
            return chain.filter(exchange)
                        .then(Mono.fromRunnable(() -> {
                            long duration = System.currentTimeMillis() - startTime;
                            System.out.println("Authorization Filter: Response Time = " + duration + " ms");
                        }));
        };
    }

    @Order(2)
    @Bean
    public GlobalFilter tokenFilter() {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            logger.info("Request >> Token :: {}", request.getHeaders()
                                                         .get("Authorization"));

            long startTime = System.currentTimeMillis();
            return chain.filter(exchange)
                        .then(Mono.fromRunnable(() -> {
                            long duration = System.currentTimeMillis() - startTime;
                            System.out.println("Token Filter: Response Time = " + duration + " ms");
                        }));
        };
    }
}

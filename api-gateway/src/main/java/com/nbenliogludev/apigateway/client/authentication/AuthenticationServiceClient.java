package com.nbenliogludev.apigateway.client.authentication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author nbenliogludev
 */
@FeignClient(name = "user-authentication-service", url = "lb://USER-AUTHENTICATION-SERVICE")
public interface AuthenticationServiceClient {

    @GetMapping("/api/auth/v1/validate")
    boolean validateToken(@RequestHeader("Authorization") String token);
}


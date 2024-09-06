package com.petsync_spring_api.petsync_spring_api.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtService jwtService;

    public String authenticate(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }
}

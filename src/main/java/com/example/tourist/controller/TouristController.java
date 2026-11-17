
package com.example.tourist.controller;

import org.springframework.web.bind.annotation.*;

import com.example.tourist.security.TokenProvider;

@RestController
@RequestMapping("/api/token")
public class TokenController {

    private final TokenProvider tokenProvider;

    public TokenController(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @GetMapping("/generate")
    public String generateToken(
            @RequestParam String username) {

        return tokenProvider.generateToken(username);
    }
}

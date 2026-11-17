
package com.example.tourist.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class TokenProvider {

    private final SecretKey key = Keys.hmacShaKeyFor(
        "MySecretKeyForTouristApplication12345678901234567890"
        .getBytes(java.nio.charset.StandardCharsets.UTF_8)
    );

    // Generate token
    public String generateToken(String username) {

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(
                    new Date(System.currentTimeMillis() + 86400000)
                )
                .signWith(key)
                .compact();
    }

    // Validate token
    public boolean validateToken(String token) {

        try {

            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}

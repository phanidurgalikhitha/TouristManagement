
package com.example.tourist.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.tourist.entity.Tourist;
import com.example.tourist.repository.TouristRepository;
import com.example.tourist.security.TokenProvider;

@Service
public class TouristServiceImpl implements TouristService {

    private final TouristRepository touristRepository;
    private final TokenProvider tokenProvider;

    public TouristServiceImpl(
            TouristRepository touristRepository,
            TokenProvider tokenProvider) {

        this.touristRepository = touristRepository;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public List<Tourist> getAllTourists(String token) {

        // Validate customer token
        if (token == null || token.isBlank()
                || !tokenProvider.validateToken(token)) {

            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Invalid Customer Token"
            );
        }

        // Fetch all tourist records
        return touristRepository.findAll();
    }
}

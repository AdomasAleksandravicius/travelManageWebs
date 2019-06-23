package com.example.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CountryExceptions extends ResponseStatusException {

    public CountryExceptions(HttpStatus status, String reason) {
        super(status, reason);
    }
}

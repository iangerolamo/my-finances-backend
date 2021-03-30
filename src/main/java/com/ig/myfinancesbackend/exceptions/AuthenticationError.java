package com.ig.myfinancesbackend.exceptions;

public class AuthenticationError extends RuntimeException {

    public AuthenticationError(String message) {
        super(message);
    }
}

package com.achadaga.aws.services;

public class InvalidUsernameException extends RuntimeException {
    public InvalidUsernameException(String username) {
        super(username + " is invalid - username must contain only alphanumeric characters (no " +
                "spaces) and must not be empty");
    }
}

package com.achadaga.aws.exceptions;

public class InvalidUsernameException extends RuntimeException {
    public InvalidUsernameException(String username) {
        super(username + " is invalid - username must contain only alphanumeric characters (no " +
                "spaces) and must not be empty");
    }
}

package com.aslanmagamaev.crypto_exchange.exceptions;

/*
 * Exception thrown by system in case someone tries to register with already existing email
 */

public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException() {
    }

    public UserAlreadyExistException(String message) {
        super(message);
    }

    public UserAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}

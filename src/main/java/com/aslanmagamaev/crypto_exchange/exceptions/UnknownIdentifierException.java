package com.aslanmagamaev.crypto_exchange.exceptions;

/*
In case customer account does not exist in the system for a given email.
 */
public class UnknownIdentifierException extends Exception {
    public UnknownIdentifierException() {
    }

    public UnknownIdentifierException(String message) {
        super(message);
    }

    public UnknownIdentifierException(String message, Throwable cause) {
        super(message, cause);
    }
}

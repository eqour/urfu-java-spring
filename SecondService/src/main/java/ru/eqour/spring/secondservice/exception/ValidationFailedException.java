package ru.eqour.spring.secondservice.exception;

public class ValidationFailedException extends Exception {

    public ValidationFailedException(String message) {
        super(message);
    }
}

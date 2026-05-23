package dev.alexandraemmeline.EventClean.Infrastructure.Exceptions;

public class DuplicateEventException extends RuntimeException {

    public DuplicateEventException(String message) {
        super(message);
    }
}

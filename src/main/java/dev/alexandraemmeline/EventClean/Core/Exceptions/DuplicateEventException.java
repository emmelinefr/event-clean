package dev.alexandraemmeline.EventClean.Core.Exceptions;

public class DuplicateEventException extends RuntimeException {

    public DuplicateEventException(String message) {
        super(message);
    }
}

package dev.alexandraemmeline.EventClean.Infrastructure.Exceptions;

public class EventoNaoEncontradoException extends RuntimeException {

    public EventoNaoEncontradoException(String message) {
        super(message);
    }
}

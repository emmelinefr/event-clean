package dev.alexandraemmeline.EventClean.Core.Exceptions;

public class EventoNaoEncontradoException extends RuntimeException {

    public EventoNaoEncontradoException(Long id) {
        super("Evento com o ID " + id + " não encontrado");
    }
}

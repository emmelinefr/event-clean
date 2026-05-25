package dev.alexandraemmeline.EventClean.Core.UseCases;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;
import dev.alexandraemmeline.EventClean.Core.Exceptions.EventNotFoundException;
import dev.alexandraemmeline.EventClean.Core.Gateway.EventoRepositoryGateway;

public class AtualizarEventoUseCaseImpl implements AtualizarEventoUseCase {

    private final EventoRepositoryGateway eventoRepositoryGateway;

    public AtualizarEventoUseCaseImpl(EventoRepositoryGateway eventoRepositoryGateway) {
        this.eventoRepositoryGateway = eventoRepositoryGateway;
    }



    @Override
    public EventoDomain execute(Long id, EventoDomain eventoDomain) {

        EventoDomain evento = eventoRepositoryGateway.buscarEvento(id);

        if (evento == null) {
            throw new EventNotFoundException("Evento de ID " + id + " não encontrado");
        }

        return eventoRepositoryGateway.atualizarEvento(id, eventoDomain);
    }

}
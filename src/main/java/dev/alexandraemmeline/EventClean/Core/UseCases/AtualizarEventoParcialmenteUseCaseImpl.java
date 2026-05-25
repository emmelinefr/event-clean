package dev.alexandraemmeline.EventClean.Core.UseCases;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;
import dev.alexandraemmeline.EventClean.Core.Exceptions.EventNotFoundException;
import dev.alexandraemmeline.EventClean.Core.Gateway.EventoRepositoryGateway;

public class AtualizarEventoParcialmenteUseCaseImpl implements AtualizarEventoParcialmenteUseCase{

    private final EventoRepositoryGateway eventoRepositoryGateway;

    public AtualizarEventoParcialmenteUseCaseImpl(EventoRepositoryGateway eventoRepositoryGateway) {
        this.eventoRepositoryGateway = eventoRepositoryGateway;
    }

    @Override
    public EventoDomain execute(Long id, EventoDomain eventoDomain) {

        EventoDomain evento = eventoRepositoryGateway.buscarEvento(id);

        if (evento == null) {
            throw new EventNotFoundException("Evento de ID " + id + " não encontrado");
        }


        eventoRepositoryGateway.atualizarParcialmenteEvento(id, eventoDomain);

        return eventoRepositoryGateway.atualizarParcialmenteEvento(id, eventoDomain);

    }
}

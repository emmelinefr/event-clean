package dev.alexandraemmeline.EventClean.Core.UseCases;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;
import dev.alexandraemmeline.EventClean.Core.Exceptions.EventoNaoEncontradoException;
import dev.alexandraemmeline.EventClean.Core.Gateway.EventoRepositoryGateway;

public class AtualizarEventoUseCaseImpl implements AtualizarEventoUseCase{

    private final EventoRepositoryGateway eventoRepositoryGateway;

    public AtualizarEventoUseCaseImpl(EventoRepositoryGateway eventoRepositoryGateway) {
        this.eventoRepositoryGateway = eventoRepositoryGateway;
    }


    @Override
    public EventoDomain execute(Long id, EventoDomain eventoDomain) {

        eventoRepositoryGateway.buscarEvento(id)
                .orElseThrow(() -> new EventoNaoEncontradoException(id));

        return eventoRepositoryGateway.atualizarEvento(id, eventoDomain);
    }
}

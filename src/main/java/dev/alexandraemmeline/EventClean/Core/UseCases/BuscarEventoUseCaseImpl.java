package dev.alexandraemmeline.EventClean.Core.UseCases;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;
import dev.alexandraemmeline.EventClean.Core.Exceptions.EventoNaoEncontradoException;
import dev.alexandraemmeline.EventClean.Core.Gateway.EventoRepositoryGateway;

public class BuscarEventoUseCaseImpl implements BuscarEventoUseCase{

    private final EventoRepositoryGateway eventoRepositoryGateway;

    public BuscarEventoUseCaseImpl(EventoRepositoryGateway eventoRepositoryGateway) {
        this.eventoRepositoryGateway = eventoRepositoryGateway;
    }


    @Override
    public EventoDomain execute(Long id) {
        return eventoRepositoryGateway.buscarEvento(id)
                .orElseThrow(() -> new EventoNaoEncontradoException(id));
    }

}

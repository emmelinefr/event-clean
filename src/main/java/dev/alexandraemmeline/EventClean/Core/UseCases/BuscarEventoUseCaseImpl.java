package dev.alexandraemmeline.EventClean.Core.UseCases;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;
import dev.alexandraemmeline.EventClean.Infrastructure.Exceptions.EventoNaoEncontradoException;
import dev.alexandraemmeline.EventClean.Core.Gateway.EventoRepositoryGateway;

public class BuscarEventoUseCaseImpl implements BuscarEventoUseCase{

    private final EventoRepositoryGateway eventoRepositoryGateway;

    public BuscarEventoUseCaseImpl(EventoRepositoryGateway eventoRepositoryGateway) {
        this.eventoRepositoryGateway = eventoRepositoryGateway;
    }


    @Override
    public EventoDomain execute(Long id) {

        EventoDomain evento = eventoRepositoryGateway.buscarEvento(id);

        if (evento == null) {
            throw new EventoNaoEncontradoException(
                    "O evento de ID " + id + " não foi encontrado. Tente novamente");
        }

        return evento;
    }

}

package dev.alexandraemmeline.EventClean.Core.UseCases;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;
import dev.alexandraemmeline.EventClean.Core.Exceptions.EventNotFoundException;
import dev.alexandraemmeline.EventClean.Core.Gateway.EventoRepositoryGateway;

public class BuscarEventoPorIdentificadorUseCaseImpl implements BuscarEventoPorIdentificadorUseCase {

    private final EventoRepositoryGateway eventoRepositoryGateway;

    public BuscarEventoPorIdentificadorUseCaseImpl(EventoRepositoryGateway eventoRepositoryGateway) {
        this.eventoRepositoryGateway = eventoRepositoryGateway;
    }


    @Override
    public EventoDomain execute(String identificador) {

        EventoDomain evento = eventoRepositoryGateway.buscarPorIdentificador(identificador);

        if (evento == null) {
            throw new EventNotFoundException("O evento com o identificador " + identificador + " não foi encontrado");
        }

        return evento;
    }

}

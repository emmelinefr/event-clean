package dev.alexandraemmeline.EventClean.Core.UseCases;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;
import dev.alexandraemmeline.EventClean.Core.Gateway.EventoRepositoryGateway;
import dev.alexandraemmeline.EventClean.Infrastructure.Exceptions.DuplicateEventException;

public class CriarEventoUseCaseImpl implements CriarEventoUseCase{

    private final EventoRepositoryGateway eventoRepositoryGateway;

    public CriarEventoUseCaseImpl(EventoRepositoryGateway eventoRepositoryGateway) {
        this.eventoRepositoryGateway = eventoRepositoryGateway;
    }


    @Override
    public EventoDomain execute(EventoDomain eventoDomain) {

        if (eventoRepositoryGateway.existePorIdentificador(eventoDomain.getIdentificador())) {
            throw new DuplicateEventException("O identificador número " + eventoDomain.getIdentificador() + " já está em uso para outro evento. Tente novamente");
        }

        return eventoRepositoryGateway.criarEvento(eventoDomain);
    }

}

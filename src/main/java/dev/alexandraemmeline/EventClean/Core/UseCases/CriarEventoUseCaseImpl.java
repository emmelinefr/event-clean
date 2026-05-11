package dev.alexandraemmeline.EventClean.Core.UseCases;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;
import dev.alexandraemmeline.EventClean.Core.Gateway.EventoRepositoryGateway;

public class CriarEventoUseCaseImpl implements CriarEventoUseCase{

    private final EventoRepositoryGateway eventoRepositoryGateway;

    public CriarEventoUseCaseImpl(EventoRepositoryGateway eventoRepositoryGateway) {
        this.eventoRepositoryGateway = eventoRepositoryGateway;
    }


    @Override
    public EventoDomain execute(EventoDomain eventoDomain) {
        return null;
    }

}

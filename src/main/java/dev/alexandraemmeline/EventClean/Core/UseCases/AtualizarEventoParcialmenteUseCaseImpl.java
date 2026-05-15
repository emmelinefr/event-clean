package dev.alexandraemmeline.EventClean.Core.UseCases;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;
import dev.alexandraemmeline.EventClean.Core.Gateway.EventoRepositoryGateway;
import dev.alexandraemmeline.EventClean.Infrastructure.Persistence.EventoRepository;

public class AtualizarEventoParcialmenteUseCaseImpl implements AtualizarEventoParcialmenteUseCase{

    private final EventoRepositoryGateway eventoRepositoryGateway;

    public AtualizarEventoParcialmenteUseCaseImpl(EventoRepositoryGateway eventoRepositoryGateway) {
        this.eventoRepositoryGateway = eventoRepositoryGateway;
    }

    @Override
    public EventoDomain execute(Long id, EventoDomain eventoDomain) {
        return eventoRepositoryGateway.atualizarParcialmenteEvento(id, eventoDomain);
    }
}

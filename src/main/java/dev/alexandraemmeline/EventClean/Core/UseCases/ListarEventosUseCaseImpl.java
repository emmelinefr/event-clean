package dev.alexandraemmeline.EventClean.Core.UseCases;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;
import dev.alexandraemmeline.EventClean.Core.Gateway.EventoRepositoryGateway;

import java.util.List;

public class ListarEventosUseCaseImpl implements ListarEventosUseCase{

    private final EventoRepositoryGateway eventoRepositoryGateway;

    public ListarEventosUseCaseImpl(EventoRepositoryGateway eventoRepositoryGateway) {
        this.eventoRepositoryGateway = eventoRepositoryGateway;
    }


    @Override
    public List<EventoDomain> execute() {
        return eventoRepositoryGateway.listarEventos();
    }

}

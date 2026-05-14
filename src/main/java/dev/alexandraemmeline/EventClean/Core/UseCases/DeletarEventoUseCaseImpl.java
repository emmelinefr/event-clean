package dev.alexandraemmeline.EventClean.Core.UseCases;

import dev.alexandraemmeline.EventClean.Core.Gateway.EventoRepositoryGateway;

public class DeletarEventoUseCaseImpl implements DeletarEventoUseCase{

    private final EventoRepositoryGateway eventoRepositoryGateway;

    public DeletarEventoUseCaseImpl(EventoRepositoryGateway eventoRepositoryGateway) {
        this.eventoRepositoryGateway = eventoRepositoryGateway;
    }


    @Override
    public void execute(Long id) {
        eventoRepositoryGateway.deletarEvento(id);
    }
}

package dev.alexandraemmeline.EventClean.Core.UseCases;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;

import java.util.List;

public interface ListarEventosUseCase {

    public List<EventoDomain> execute();

}

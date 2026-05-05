package dev.alexandraemmeline.EventClean.Core.UseCases;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;

public interface BuscarEventoUseCase {

    public EventoDomain execute(Integer id);

}

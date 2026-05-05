package dev.alexandraemmeline.EventClean.Core.UseCases;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;

public interface CriarEventoUseCase {

    public EventoDomain execute(EventoDomain eventoDomain);

}

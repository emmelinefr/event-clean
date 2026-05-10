package dev.alexandraemmeline.EventClean.Core.UseCases;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;

public interface CriarEventoUseCase {

    EventoDomain execute(EventoDomain eventoDomain);

}

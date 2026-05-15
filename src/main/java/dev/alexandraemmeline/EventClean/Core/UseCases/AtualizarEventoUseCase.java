package dev.alexandraemmeline.EventClean.Core.UseCases;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;

public interface AtualizarEventoUseCase {

    EventoDomain execute(Long id, EventoDomain eventoDomain);

}

package dev.alexandraemmeline.EventClean.Core.UseCases;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;

public interface BuscarEventoPorIdentificadorUseCase {

    EventoDomain execute(String identificador);
}

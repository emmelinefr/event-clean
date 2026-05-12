package dev.alexandraemmeline.EventClean.Core.Gateway;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;

public interface EventoRepositoryGateway {

     EventoDomain criarEvento(EventoDomain eventoDomain);

     EventoDomain buscarEvento(Long id);

}

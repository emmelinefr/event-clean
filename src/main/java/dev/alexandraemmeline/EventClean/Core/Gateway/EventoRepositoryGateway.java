package dev.alexandraemmeline.EventClean.Core.Gateway;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;

import java.util.List;
import java.util.Optional;

public interface EventoRepositoryGateway {

     EventoDomain criarEvento(EventoDomain eventoDomain);

     Optional<EventoDomain> buscarEvento(Long id);

     List<EventoDomain> listarEventos();

     void deletarEvento(Long id);

     EventoDomain atualizarEvento(Long id, EventoDomain eventoDomain);

     EventoDomain atualizarParcialmenteEvento(Long id, EventoDomain eventoDomain);
}

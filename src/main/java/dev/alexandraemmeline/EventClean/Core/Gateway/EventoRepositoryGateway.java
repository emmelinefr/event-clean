package dev.alexandraemmeline.EventClean.Core.Gateway;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;

import java.util.List;

public interface EventoRepositoryGateway {

     EventoDomain criarEvento(EventoDomain eventoDomain);

     EventoDomain buscarEvento(Long id);

     List<EventoDomain> listarEventos();

     void deletarEvento(Long id);

     EventoDomain atualizarEvento(Long id, EventoDomain eventoDomain);

     EventoDomain atualizarParcialmenteEvento(Long id, EventoDomain eventoDomain);
}

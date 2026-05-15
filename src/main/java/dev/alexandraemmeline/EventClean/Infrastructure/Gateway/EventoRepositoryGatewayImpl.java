package dev.alexandraemmeline.EventClean.Infrastructure.Gateway;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;
import dev.alexandraemmeline.EventClean.Core.Gateway.EventoRepositoryGateway;
import dev.alexandraemmeline.EventClean.Infrastructure.Mappers.EventoEntityMapper;
import dev.alexandraemmeline.EventClean.Infrastructure.Persistence.EventoEntity;
import dev.alexandraemmeline.EventClean.Infrastructure.Persistence.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventoRepositoryGatewayImpl implements EventoRepositoryGateway {

    private final EventoEntityMapper eventoEntityMapper;
    private final EventoRepository eventoRepository;


    @Override
    public EventoDomain criarEvento(EventoDomain eventoDomain) {

        EventoEntity novoEvento = eventoRepository.save(eventoEntityMapper.toEntity(eventoDomain));

        return eventoEntityMapper.toDomain(novoEvento);

    }


    @Override
    public EventoDomain buscarEvento(Long id) {

        return eventoRepository.findById(id)
                .map(eventoEntityMapper::toDomain)
                .orElse(null);
    }


    @Override
    public List<EventoDomain> listarEventos() {

        return eventoRepository.findAll()
                .stream()
                .map(eventoEntityMapper::toDomain)
                .toList();
    }


    @Override
    public void deletarEvento(Long id) {
        eventoRepository.deleteById(id);
    }


    @Override
    public EventoDomain atualizarEvento(Long id, EventoDomain eventoDomain) {

        EventoEntity eventoExistente = eventoRepository.findById(id)
                .orElse(null);

        if (eventoExistente == null) {
            return null;
        }

        eventoExistente.setNome(eventoDomain.getNome());
        eventoExistente.setDescricao(eventoDomain.getDescricao());
        eventoExistente.setIdentificador(eventoDomain.getIdentificador());
        eventoExistente.setDataInicio(eventoDomain.getDataInicio());
        eventoExistente.setDataFim(eventoDomain.getDataFim());
        eventoExistente.setLocalEvento(eventoDomain.getLocalEvento());
        eventoExistente.setOrganizador(eventoDomain.getOrganizador());
        eventoExistente.setCapacidade(eventoDomain.getCapacidade());
        eventoExistente.setTipo(eventoDomain.getTipo());

        EventoEntity eventoAtualizado = eventoRepository.save(eventoExistente);

        return eventoEntityMapper.toDomain(eventoAtualizado);
    }
}

package dev.alexandraemmeline.EventClean.Infrastructure.Mappers;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;
import dev.alexandraemmeline.EventClean.Infrastructure.DTOs.EventoDTO;
import org.springframework.stereotype.Component;

@Component
public class EventoMapper {

    public EventoDTO toDTO(EventoDomain eventoDomain) {

        return new EventoDTO(
                eventoDomain.getId(),
                eventoDomain.getNome(),
                eventoDomain.getDescricao(),
                eventoDomain.getIdentificador(),
                eventoDomain.getDataInicio(),
                eventoDomain.getDataFim(),
                eventoDomain.getLocalEvento(),
                eventoDomain.getOrganizador(),
                eventoDomain.getCapacidade(),
                eventoDomain.getTipo()
        );

    }


    public EventoDomain toDomain(EventoDTO eventoDTO) {

        return new EventoDomain(
                eventoDTO.id(),
                eventoDTO.nome(),
                eventoDTO.descricao(),
                eventoDTO.identificador(),
                eventoDTO.dataInicio(),
                eventoDTO.dataFim(),
                eventoDTO.localEvento(),
                eventoDTO.organizador(),
                eventoDTO.capacidade(),
                eventoDTO.tipo()
        );
    }

}

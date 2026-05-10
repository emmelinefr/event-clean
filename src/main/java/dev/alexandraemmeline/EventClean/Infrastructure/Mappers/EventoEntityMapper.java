package dev.alexandraemmeline.EventClean.Infrastructure.Mappers;

import dev.alexandraemmeline.EventClean.Core.Domains.EventoDomain;
import dev.alexandraemmeline.EventClean.Infrastructure.Persistence.EventoEntity;
import org.springframework.stereotype.Component;

@Component
public class EventoEntityMapper {

    public EventoEntity toEntity(EventoDomain eventoDomain) {

        return new EventoEntity(
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


    public EventoDomain toDomain(EventoEntity eventoEntity) {

        return new EventoDomain(
                eventoEntity.getId(),
                eventoEntity.getNome(),
                eventoEntity.getDescricao(),
                eventoEntity.getIdentificador(),
                eventoEntity.getDataInicio(),
                eventoEntity.getDataFim(),
                eventoEntity.getLocalEvento(),
                eventoEntity.getOrganizador(),
                eventoEntity.getCapacidade(),
                eventoEntity.getTipo()
        );
    }

}

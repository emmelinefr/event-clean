package dev.alexandraemmeline.EventClean.core.entities;
import dev.alexandraemmeline.EventClean.core.enums.TipoEvento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public record Evento(

        Long id,
        String nome,
        String descricao,
        String identificador,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        LocalDateTime localEvento,
        Integer capacidade,
        String organizador,
        TipoEvento tipo

) {}

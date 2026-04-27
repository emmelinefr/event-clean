package dev.alexandraemmeline.EventClean.core.entities;
import dev.alexandraemmeline.EventClean.core.enums.TipoEvento;

import java.time.LocalDateTime;

public record Evento(

        Long id,
        String nome,
        String descricao,
        String identificador,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        LocalDateTime local,
        String organizador,
        TipoEvento tipo

) {}

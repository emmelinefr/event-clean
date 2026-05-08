package dev.alexandraemmeline.EventClean.Infrastructure.DTOs;

import dev.alexandraemmeline.EventClean.Core.Enums.TipoEvento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EventoDTO(

        Long id,

        @NotBlank
        String nome,

        @NotBlank
        String descricao,

        @NotBlank
        String identificador,

        @NotNull
        LocalDateTime dataInicio,

        @NotNull
        LocalDateTime dataFim,

        @NotNull
        String localEvento,

        @NotBlank
        String organizador,

        @NotNull
        Integer capacidade,

        @NotNull
        TipoEvento tipo

) {
}

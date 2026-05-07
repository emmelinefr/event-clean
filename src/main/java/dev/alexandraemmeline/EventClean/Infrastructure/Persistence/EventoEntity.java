package dev.alexandraemmeline.EventClean.Infrastructure.Persistence;

import dev.alexandraemmeline.EventClean.Core.Enums.TipoEvento;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "eventos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @Column(unique = true)
    private String identificador;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    @Column(name = "local_evento")
    private String localEvento;

    private String organizador;

    private Integer capacidade;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipo;


}

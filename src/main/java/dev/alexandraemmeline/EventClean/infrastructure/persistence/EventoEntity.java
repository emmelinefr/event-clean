package dev.alexandraemmeline.EventClean.infrastructure.persistence;

import dev.alexandraemmeline.EventClean.core.enums.TipoEvento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Eventos")
public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String identificador;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private LocalDateTime localEvento;
    private Integer capacidade;
    private String organizador;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipo;

}

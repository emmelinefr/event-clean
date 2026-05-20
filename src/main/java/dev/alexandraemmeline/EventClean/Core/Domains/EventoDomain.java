package dev.alexandraemmeline.EventClean.Core.Domains;

import dev.alexandraemmeline.EventClean.Core.Enums.TipoEvento;
import dev.alexandraemmeline.EventClean.Core.Exceptions.PeriodoEventoInvalidoException;

import java.time.LocalDateTime;

public class EventoDomain {

    private Long id;
    private String nome;
    private String descricao;
    private String identificador;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String localEvento;
    private String organizador;
    private Integer capacidade;
    private TipoEvento tipo;


    public EventoDomain(Long id, String nome, String descricao, String identificador, LocalDateTime dataInicio, LocalDateTime dataFim, String localEvento, String organizador, Integer capacidade, TipoEvento tipo) {

        validarDatas(dataInicio, dataFim);

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.identificador = identificador;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.localEvento = localEvento;
        this.organizador = organizador;
        this.capacidade = capacidade;
        this.tipo = tipo;
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getIdentificador() {
        return identificador;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public String getOrganizador() {
        return organizador;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public TipoEvento getTipo() {
        return tipo;
    }


    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }


    public void alterarDatas(LocalDateTime dataInicio, LocalDateTime dataFim) {

        validarDatas(dataInicio, dataFim);

        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }


    private void validarDatas(LocalDateTime dataInicio, LocalDateTime dataFim) {

        if (dataInicio == null || dataFim == null) {
            throw new PeriodoEventoInvalidoException("As datas do evento são obrigatórias");
        }

        if (dataFim.isBefore(dataInicio)) {
            throw new PeriodoEventoInvalidoException("A data fim não pode ser antes da data início");
        }

    }

}

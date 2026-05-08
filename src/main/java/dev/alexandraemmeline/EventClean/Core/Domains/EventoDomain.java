package dev.alexandraemmeline.EventClean.Core.Domains;

import dev.alexandraemmeline.EventClean.Core.Enums.TipoEvento;

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
        //TODO tratar com exception
        if (dataInicio == null || dataFim == null || dataFim.isBefore(dataInicio)) {
            System.out.println("Período Inválido");
        }

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

    //TODO tratar com exception
    public void setDataInicio(LocalDateTime dataInicio) {
        if (dataInicio.isAfter(dataFim)) {
            System.out.println("Período Inválido");

        }
        this.dataInicio = dataInicio;
    }

    //TODO tratar com exception
    public void setDataFim(LocalDateTime dataFim) {
        if (dataFim.isBefore(dataInicio)) {
            System.out.println("Período Inválido");
        }
        this.dataFim = dataFim;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

}

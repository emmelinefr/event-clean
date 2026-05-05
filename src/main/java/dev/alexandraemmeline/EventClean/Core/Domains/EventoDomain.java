package dev.alexandraemmeline.EventClean.Core.Domains;

import dev.alexandraemmeline.EventClean.Core.Enums.TipoEvento;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EventoDomain {

    private Integer id;
    private String nome;
    private String descricao;
    private String identificador;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String local;
    private String organizador;
    private TipoEvento tipo;


    public EventoDomain(Integer id, String nome, String descricao, String identificador, LocalDateTime dataInicio, LocalDateTime dataFim, String local, String organizador, TipoEvento tipo) {
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
        this.local = local;
        this.organizador = organizador;
        this.tipo = tipo;
    }


    public Integer getId() {
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

    public String getLocal() {
        return local;
    }

    public String getOrganizador() {
        return organizador;
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

    public void setLocal(String local) {
        this.local = local;
    }
}

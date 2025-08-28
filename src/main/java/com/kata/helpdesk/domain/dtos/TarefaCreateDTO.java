package com.kata.helpdesk.domain.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class  TarefaCreateDTO {
    @NotBlank
    private String titulo;

    private String descricao;

    private String status;

    @NotNull
    private Long idProjeto;

    // Getters e Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Long idProjeto) {
        this.idProjeto = idProjeto;
    }
}

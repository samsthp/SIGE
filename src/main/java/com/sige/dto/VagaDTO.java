package com.sige.dto;

public class VagaDTO {

    private String titulo;
    private String descricao;
    private String salario;
    private String requisitos;
    private Long empresaId;

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getSalario() { return salario; }
    public void setSalario(String salario) { this.salario = salario; }

    public String getRequisitos() { return requisitos; }
    public void setRequisitos(String requisitos) { this.requisitos = requisitos; }

    public Long getEmpresaId() { return empresaId; }
    public void setEmpresaId(Long empresaId) { this.empresaId = empresaId; }
}

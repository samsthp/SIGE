package com.sige.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    private String estado;
    private String cursoRelacionado;
    private String contato;

    @NotNull
    private String salario;

    private String requisitos;

    // EMPRESA É UM USUÁRIO (ROLE_EMPRESA)
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Usuario empresa;

    private LocalDateTime criadoEm = LocalDateTime.now();

    // ======================
    // GETTERS E SETTERS
    // ======================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCursoRelacionado() {
        return cursoRelacionado;
    }

    public void setCursoRelacionado(String cursoRelacionado) {
        this.cursoRelacionado = cursoRelacionado;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public Usuario getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Usuario empresa) {
        this.empresa = empresa;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }
}

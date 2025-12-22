package com.sigecertificado.sige_emissao_certificado_estagio.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "certificado_aluno")
public class Certificado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String empresa;
    @Column(name= "data_emissao")
    private LocalDate dataEmissao;
    
    public Certificado(Long id, String nome, String empresa, LocalDate dataEmissao) {
        this.id = id;
        this.nome = nome;
        this.empresa = empresa;
        this.dataEmissao = dataEmissao;
    }
    public Certificado() {
    }
    
    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEmpresa() {
        return empresa;
    }
    public LocalDate getDataEmissao() {
        return dataEmissao;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}

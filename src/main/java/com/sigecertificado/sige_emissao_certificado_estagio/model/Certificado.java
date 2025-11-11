package com.sigecertificado.sige_emissao_certificado_estagio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Table(name = "certificado_aluno")
public class Certificado {
    @Id  
    private Long id;
    private String nome;
    private String empresa;
    private ZonedDateTime dataEmissao;
    
    public Certificado(Long id, String nome, String empresa, ZonedDateTime dataEmissao) {
        this.id = id;
        this.nome = nome;
        this.empresa = empresa;
        this.dataEmissao = dataEmissao;
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
    public ZonedDateTime getDataEmissao() {
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
    public void setDataEmissao(ZonedDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}

package com.sigecertificado.sige_emissao_certificado_estagio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Table(name = "certificado_aluno")
public class Certificado {
    private Integer id;
    private String nome;
    private String estagio;
    private ZonedDateTime dataEmissao;
    
    public Certificado(Integer id, String nome, String estagio, ZonedDateTime dataEmissao) {
        this.id = id;
        this.nome = nome;
        this.estagio = estagio;
        this.dataEmissao = dataEmissao;
    }
    
    public Integer getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEstagio() {
        return estagio;
    }
    public ZonedDateTime getDataEmissao() {
        return dataEmissao;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEstagio(String estagio) {
        this.estagio = estagio;
    }
    public void setDataEmissao(ZonedDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}

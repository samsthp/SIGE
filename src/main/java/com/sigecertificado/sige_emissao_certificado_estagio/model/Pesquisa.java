package com.sigecertificado.sige_emissao_certificado_estagio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pesquisa_com_filtros")
public class Pesquisa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String area;
    private String local;
    private String modalidade;
}
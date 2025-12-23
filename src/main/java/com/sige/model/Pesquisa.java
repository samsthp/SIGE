package com.sige.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pesquisa_com_filtros")
public class Pesquisa {
    @Id
    private Long id;
    private String titulo;
    private String descricao;
    private String area;
    @Column(name= "local_vaga")
    private String local;
    private String modalidade;
}
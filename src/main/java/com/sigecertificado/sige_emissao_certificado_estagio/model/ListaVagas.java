package com.sigecertificado.sige_emissao_certificado_estagio.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lista_de_vagas")
public class ListaVagas {
    @Id
    private Long id;
    private String status;
    @Column(name= "data_vaga")
    private LocalDate data;
    private String titulo;
    private String descricao;
    private String area;
    @Column(name= "local_vaga")
    private String local;
    private String modalidade;
}

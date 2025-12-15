package com.sigecertificado.sige_emissao_certificado_estagio.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lista_de_vagas")
public class ListaVagas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private LocalDate data;
    private String titulo;
    private String descricao;
    private String area;
    private String local;
    private String modalidade;
}

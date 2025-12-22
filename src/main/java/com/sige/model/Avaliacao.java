package com.sige.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int nota;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
@JoinColumn(name = "aluno_id", nullable = false)
private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;
}
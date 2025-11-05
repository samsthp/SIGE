package com.sige.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "oferta_id")
    private OfertaEstagio oferta;

    // Status da candidatura: PENDENTE, ACEITA, RECUSADA
    @Enumerated(EnumType.STRING)
    private StatusCandidatura status = StatusCandidatura.PENDENTE;
}
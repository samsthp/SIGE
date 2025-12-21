package com.sige.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // aluno que se candidatou
    @ManyToOne(optional = false)
    @JoinColumn(name = "aluno_id")
    private Usuario aluno;

    // vaga escolhida
    @ManyToOne(optional = false)
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;

    @Column(nullable = false)
    private String status; // PENDENTE, ACEITA, RECUSADA

    @Column(nullable = false)
    private LocalDateTime dataCandidatura = LocalDateTime.now();
}

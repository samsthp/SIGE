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

    // 👨‍🎓 Aluno
    @ManyToOne(optional = false)
    @JoinColumn(name = "aluno_id")
    private Usuario aluno;

    // 📄 VAGA
    @ManyToOne(optional = false)
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;

    // 📌 Status
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusCandidatura status = StatusCandidatura.INSCRITO;

    @Column(nullable = false)
    private LocalDateTime dataCandidatura = LocalDateTime.now();
}

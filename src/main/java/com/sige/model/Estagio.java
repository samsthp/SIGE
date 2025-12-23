package com.sige.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "estagios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estagio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 👨‍🎓 Aluno
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Usuario aluno;

    // 🏢 Empresa
    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Usuario empresa;

    // 📄 Vaga
    @ManyToOne
    @JoinColumn(name = "vaga_id", nullable = false)
    private Vaga vaga;

    // 📌 Status do estágio
    @Column(nullable = false)
    private String status; // ATIVO, CONCLUIDO, CANCELADO

    // 📅 Data de início
    private LocalDateTime dataInicio = LocalDateTime.now();
}

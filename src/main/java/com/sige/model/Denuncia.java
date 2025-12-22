package com.sige.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Aluno que denunciou
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Usuario aluno;

    // Estágio denunciado
    @ManyToOne
    @JoinColumn(name = "estagio_id", nullable = false)
    private Estagio estagio;

    @Column(nullable = false, length = 1000)
    private String descricao;

    @Column(nullable = false)
    private String status;
    // PENDENTE, MANTIDO, REMOVIDO

    private LocalDateTime dataCriacao = LocalDateTime.now();
}

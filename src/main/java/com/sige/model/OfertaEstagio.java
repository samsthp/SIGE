package com.sige.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "oferta_estagio")
public class OfertaEstagio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campo principal do formulário
    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricaoVaga;

    // Relacionamento com a empresa que criou a oferta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    // Data de criação da oferta
    @Column(nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    // Status da oferta: ABERTA, ENCERRADA, etc.
    @Column(nullable = false, length = 20)
    private String status = "ABERTA";
}
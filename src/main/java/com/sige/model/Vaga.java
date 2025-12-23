package com.sige.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    private String estado;
    private String cursoRelacionado;
    private String contato;

    @NotNull
    private String salario;

    private String requisitos;

    // EMPRESA É UM USUÁRIO COM ROLE_EMPRESA
    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Usuario empresa;

    private LocalDateTime criadoEm = LocalDateTime.now();
}

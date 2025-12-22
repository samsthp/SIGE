package com.sige.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
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
<<<<<<< HEAD

    private String estado;
    private String cursoRelacionado;
    private String contato;


    @NotNull
    private String salario;
    private String requisitos;
  
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    private LocalDateTime criadoEm = LocalDateTime.now();
}
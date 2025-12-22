package com.sige.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String cpf;
    private String cnpj;
    private String matricula;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String tipo; // aluno, empresa, coordenador

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnumRole role;
}

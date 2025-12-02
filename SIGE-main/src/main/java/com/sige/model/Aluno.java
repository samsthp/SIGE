package com.sige.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "alunos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;

    private String endereco;
    private String senha;
    private String fotoPerfil;
}

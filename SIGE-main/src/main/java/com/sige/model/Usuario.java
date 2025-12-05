package com.sige.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;
import java.util.List;

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

    // 🔹 CPF — obrigatório p/ aluno e coordenador
    @Column(unique = true)
    private String cpf;

    // 🔹 CNPJ — obrigatório p/ empresa
    @Column(unique = true)
    private String cnpj;

    // 🔹 Matrícula — gerada automaticamente p/ aluno
    @Column(unique = true)
    private String matricula;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    private String endereco;

    @Column(nullable = false)
    private String tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnumRole role;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> role.name());
    }
}

package com.sige.model;

import jakarta.persistence.*;
<<<<<<< HEAD
=======
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;
import java.util.List;
>>>>>>> origin/main

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
<<<<<<< HEAD

    private String cpf;
    private String cnpj;
    private String matricula;
    private String senha;
    private String tipo;


    @Enumerated(EnumType.STRING)
    private EnumRole role;

    // ================= GETTERS =================
    public Long getId() {
        return id;

    }
<<<<<<< HEAD

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipo() {
        return tipo;
    }

    public EnumRole getRole() {
        return role;
    }

    // ================= SETTERS =================
    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setRole(EnumRole role) {
        this.role = role;
    }

}
=======

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
    private String tipo; // aluno, empresa, coordenador

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnumRole role;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> role.name());
    }
}
>>>>>>> origin/main

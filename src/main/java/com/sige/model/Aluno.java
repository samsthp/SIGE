package com.sige.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(nullable = false)
    private LocalDate nascimento;

    @Column(nullable = false, unique = true, length = 20)
    private String matricula;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(nullable = false, length = 255)
    private String endereco;

    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @Column(nullable = false)
    private String senha;

    // Construtores
    public Aluno() {}

    public Aluno(String nome, String cpf, LocalDate nascimento, String matricula,
                 String telefone, String endereco, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.matricula = matricula;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public LocalDate getNascimento() { return nascimento; }
    public void setNascimento(LocalDate nascimento) { this.nascimento = nascimento; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nascimento=" + nascimento +
                ", matricula='" + matricula + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
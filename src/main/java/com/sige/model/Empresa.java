package com.sige.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, unique = true, length = 18)
    private String cnpj;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(nullable = false, length = 255)
    private String endereco;

    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @Column(nullable = false)
    private String senha;

    // Construtores
    public Empresa() {}

    public Empresa(String nome, String cnpj, String telefone, String endereco, String email, String senha) {
        this.nome = nome;
        this.cnpj = cnpj;
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

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    // toString
    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
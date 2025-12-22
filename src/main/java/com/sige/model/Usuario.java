package com.sige.model;

<<<<<<< HEAD
import jakarta.persistence.*;

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
=======

<<<<<<< HEAD
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
=======
>>>>>>> 6e516700151d0d8c92cf620a360faec33aa9aa0d
}

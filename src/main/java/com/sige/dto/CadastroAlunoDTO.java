
package com.sige.dto;

import jakarta.validation.constraints.NotBlank;

public class CadastroAlunoDTO {

    @NotBlank private String nome;
    @NotBlank private String email;
    @NotBlank private String cpf;
    @NotBlank private String nascimento;
    @NotBlank private String matricula;
    @NotBlank private String telefone;
    @NotBlank private String endereco;
    @NotBlank private String senha;

    // Getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getNascimento() { return nascimento; }
    public void setNascimento(String nascimento) { this.nascimento = nascimento; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}

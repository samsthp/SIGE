package com.sige.dto;

public class LoginRequest {
    private String tipo;
    private String identificador;
    private String senha;

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getIdentificador() { return identificador; }
    public void setIdentificador(String identificador) { this.identificador = identificador; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

}

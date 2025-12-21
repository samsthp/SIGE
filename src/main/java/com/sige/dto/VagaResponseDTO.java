package com.sige.dto;

import com.sige.model.Vaga;

public class VagaResponseDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private String cursoRelacionado;
    private String estado;
    private String salario;

    // dados da empresa
    private Long empresaId;
    private String empresaNome;
    private String empresaEmail;

    // métricas
    private long interessados;

    public VagaResponseDTO(Vaga vaga, long interessados) {
        this.id = vaga.getId();
        this.titulo = vaga.getTitulo();
        this.descricao = vaga.getDescricao();
        this.cursoRelacionado = vaga.getCursoRelacionado();
        this.estado = vaga.getEstado();
        this.salario = vaga.getSalario();

        if (vaga.getEmpresa() != null) {
            this.empresaId = vaga.getEmpresa().getId();
            this.empresaNome = vaga.getEmpresa().getNome();
            this.empresaEmail = vaga.getEmpresa().getEmail();
        }

        this.interessados = interessados;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getCursoRelacionado() { return cursoRelacionado; }
    public String getEstado() { return estado; }
    public String getSalario() { return salario; }

    public Long getEmpresaId() { return empresaId; }
    public String getEmpresaNome() { return empresaNome; }
    public String getEmpresaEmail() { return empresaEmail; }

    public long getInteressados() { return interessados; }
}

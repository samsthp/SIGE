package com.sige.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estagios")
public class Estagio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String empresa;
    private String periodo;
    private String atividades;
    private String tarefas;
    private String avaliacao;
    private int horasCumpridas;
    private String documentos;
    private String statusGeral;
    private String situacaoFinal;

    // Relacionamento com Aluno
    @ManyToOne
    @JoinColumn(name = "aluno_id") // coluna no banco
    private Aluno aluno;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }

    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }

    public String getAtividades() { return atividades; }
    public void setAtividades(String atividades) { this.atividades = atividades; }

    public String getTarefas() { return tarefas; }
    public void setTarefas(String tarefas) { this.tarefas = tarefas; }

    public String getAvaliacao() { return avaliacao; }
    public void setAvaliacao(String avaliacao) { this.avaliacao = avaliacao; }

    public int getHorasCumpridas() { return horasCumpridas; }
    public void setHorasCumpridas(int horasCumpridas) { this.horasCumpridas = horasCumpridas; }

    public String getDocumentos() { return documentos; }
    public void setDocumentos(String documentos) { this.documentos = documentos; }

    public String getStatusGeral() { return statusGeral; }
    public void setStatusGeral(String statusGeral) { this.statusGeral = statusGeral; }

    public String getSituacaoFinal() { return situacaoFinal; }
    public void setSituacaoFinal(String situacaoFinal) { this.situacaoFinal = situacaoFinal; }

    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }
}

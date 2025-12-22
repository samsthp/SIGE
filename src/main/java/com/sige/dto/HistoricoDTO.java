package com.sige.dto;

import com.sige.model.Estagio;

public class HistoricoDTO {
    private String empresa;
    private String periodo;
    private String atividades;
    private String tarefas;
    private String avaliacao;
    private int horasCumpridas;
    private String documentos;
    private String statusGeral;
    private String situacaoFinal;

    // Construtor que recebe um Estagio
    public HistoricoDTO(Estagio estagio) {
        this.empresa = estagio.getEmpresa();
        this.periodo = estagio.getPeriodo();
        this.atividades = estagio.getAtividades();
        this.tarefas = estagio.getTarefas();
        this.avaliacao = estagio.getAvaliacao();
        this.horasCumpridas = estagio.getHorasCumpridas();
        this.documentos = estagio.getDocumentos();
        this.statusGeral = estagio.getStatusGeral();
        this.situacaoFinal = estagio.getSituacaoFinal();
    }

    // Getters
    public String getEmpresa() { return empresa; }
    public String getPeriodo() { return periodo; }
    public String getAtividades() { return atividades; }
    public String getTarefas() { return tarefas; }
    public String getAvaliacao() { return avaliacao; }
    public int getHorasCumpridas() { return horasCumpridas; }
    public String getDocumentos() { return documentos; }
    public String getStatusGeral() { return statusGeral; }
    public String getSituacaoFinal() { return situacaoFinal; }
}

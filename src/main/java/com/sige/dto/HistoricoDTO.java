package com.sige.dto;

import com.sige.model.Estagio;

public class HistoricoDTO {
    private String empresa;
    private String tituloVaga;
    private String status;

    public HistoricoDTO(Estagio estagio) {
        this.empresa = estagio.getVaga() != null && estagio.getVaga().getEmpresa() != null
                ? estagio.getVaga().getEmpresa().getNome()
                : "Indefinido";
        this.tituloVaga = estagio.getVaga() != null ? estagio.getVaga().getTitulo() : "Indefinido";
        this.status = estagio.getStatus() != null ? estagio.getStatus() : "Indefinido";
    }

    // Getters e setters
    public String getEmpresa() { return empresa; }
    public String getTituloVaga() { return tituloVaga; }
    public String getStatus() { return status; }
}

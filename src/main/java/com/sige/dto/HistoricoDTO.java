package com.sige.dto;

import com.sige.model.Estagio;
import com.sige.model.Usuario;

public class HistoricoDTO {

    private String empresaNome;
    private String empresaEmail;

    private String status;
    private String dataInicio;

    // Construtor que recebe um Estagio
    public HistoricoDTO(Estagio estagio) {

        Usuario empresa = estagio.getEmpresa();
        if (empresa != null) {
            this.empresaNome = empresa.getNome();
            this.empresaEmail = empresa.getEmail();
        }

        this.status = estagio.getStatus();
        this.dataInicio = estagio.getDataInicio() != null
                ? estagio.getDataInicio().toString()
                : null;
    }

    public String getEmpresaNome() {
        return empresaNome;
    }

    public String getEmpresaEmail() {
        return empresaEmail;
    }

    public String getStatus() {
        return status;
    }

    public String getDataInicio() {
        return dataInicio;
    }
}

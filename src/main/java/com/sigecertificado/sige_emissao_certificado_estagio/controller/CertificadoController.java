package com.sigecertificado.sige_emissao_certificado_estagio.controller;

import com.sigecertificado.sige_emissao_certificado_estagio.service.CertificadoService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CertificadoController {
    private final CertificadoService certificadoServico;
    
    public CertificadoController(CertificadoService certificadoService) {
        certificadoServico = certificadoService;
    }
}

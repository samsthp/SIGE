package com.sigecertificado.sige_emissao_certificado_estagio.controller;

import com.sigecertificado.sige_emissao_certificado_estagio.emitircertificado.EmitirCertificado;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/certificados")
public class CertificadoController {
    private final EmitirCertificado emitirCertificado;
    
    public CertificadoController(EmitirCertificado emitir) {
        emitirCertificado = emitir;
    }
    
    @GetMapping
    public byte[] gerarPdf(Long Id) {
        byte[] pdf = emitirCertificado.emitirPdf(Id);
        return pdf;
    }
}

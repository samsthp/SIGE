package com.sigecertificado.sige_emissao_certificado_estagio.controller;

import com.sigecertificado.sige_emissao_certificado_estagio.emitircertificado.EmitirCertificado;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api/certificados")
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
    @GetMapping("favicon.icon")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void ignorarFavicon() {
    }
}

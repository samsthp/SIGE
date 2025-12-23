package com.sige.controller;

import com.sige.model.Certificado;
import com.sige.service.EmitirCertificadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api/certificados")
public class CertificadoController {
    private final EmitirCertificadoService emitirCertificado;
    
    public CertificadoController(EmitirCertificadoService emitir) {
        emitirCertificado = emitir;
    }
    
    @PostMapping
    public ResponseEntity<byte[]> gerarPdf(@RequestBody Certificado certificado) {
        byte[] pdf = emitirCertificado.emitirPdf(certificado);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=certificado.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}

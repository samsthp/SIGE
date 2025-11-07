package com.sigecertificado.sige_emissao_certificado_estagio.service;

import com.sigecertificado.sige_emissao_certificado_estagio.repository.CertificadoRepository;

public class CertificadoService {
    private final CertificadoRepository certificadoRepositorio;
    
    public CertificadoService(CertificadoRepository certificadoRepository) {
        certificadoRepositorio = certificadoRepository;
    }
}

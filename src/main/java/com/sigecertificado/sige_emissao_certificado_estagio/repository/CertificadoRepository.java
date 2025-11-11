package com.sigecertificado.sige_emissao_certificado_estagio.repository;

import com.sigecertificado.sige_emissao_certificado_estagio.model.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificadoRepository extends JpaRepository<Certificado, Long>{
}

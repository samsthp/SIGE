package com.sigecertificado.sige_emissao_certificado_estagio.repository;

import com.sigecertificado.sige_emissao_certificado_estagio.model.ListaVagas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaVagasRepository extends JpaRepository<ListaVagas, Long> {
    
}

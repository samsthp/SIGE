package com.sigecertificado.sige_emissao_certificado_estagio.repository;

import com.sigecertificado.sige_emissao_certificado_estagio.model.Pesquisa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PesquisaRepository extends JpaRepository<Pesquisa, Long>, JpaSpecificationExecutor {
}

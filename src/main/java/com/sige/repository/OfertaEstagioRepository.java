package com.sige.repository;

import com.sige.model.OfertaEstagio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OfertaEstagioRepository extends JpaRepository<OfertaEstagio, Long> {
    List<OfertaEstagio> findByEmpresaId(Long empresaId);
}
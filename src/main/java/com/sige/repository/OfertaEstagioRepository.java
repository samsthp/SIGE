package com.sige.repository;

import com.sige.model.OfertaEstagio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfertaEstagioRepository extends JpaRepository<OfertaEstagio, Long> {
    List<OfertaEstagio> findByEmpresaId(Long empresaId);
}

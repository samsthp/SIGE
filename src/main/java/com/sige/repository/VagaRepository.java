package com.sige.repository;

import com.sige.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
    List<Vaga> findByCursoRelacionadoContainingIgnoreCase(String curso);
    List<Vaga> findByEstadoContainingIgnoreCase(String estado);
    List<Vaga> findByEmpresaContainingIgnoreCase(String empresa);
}

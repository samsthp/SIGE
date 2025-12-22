package com.sige.repository;

import com.sige.model.Estagio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstagioRepository extends JpaRepository<Estagio, Long> {

    List<Estagio> findByAlunoIdAndStatus(Long alunoId, String status);

    List<Estagio> findByEmpresaIdAndStatus(Long empresaId, String status);
}

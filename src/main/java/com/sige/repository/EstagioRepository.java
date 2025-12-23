package com.sige.repository;

import com.sige.model.Estagio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstagioRepository extends JpaRepository<Estagio, Long> {

    List<Estagio> findByAluno_Id(Long alunoId);

    List<Estagio> findByAluno_IdAndStatus(Long alunoId, String status);

    List<Estagio> findByEmpresa_IdAndStatus(Long empresaId, String status);
}

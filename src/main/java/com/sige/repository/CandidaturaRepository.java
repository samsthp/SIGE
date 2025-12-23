package com.sige.repository;

import com.sige.model.Candidatura;
import com.sige.model.StatusCandidatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {

    // ✅ Por VAGA
    List<Candidatura> findByVagaId(Long vagaId);

    long countByVagaId(Long vagaId);

    // ✅ Por ALUNO
    List<Candidatura> findByAlunoId(Long alunoId);

    // ✅ Por STATUS
    List<Candidatura> findByStatus(StatusCandidatura status);
}

package com.sige.repository;

import com.sige.model.Candidatura;
import com.sige.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {

    // 🔢 Conta quantos alunos se candidataram a uma vaga (usado no DTO da vaga)
    long countByVaga(Vaga vaga);

    // 🔢 Conta quantos alunos se candidataram pelo ID da vaga
    long countByVagaId(Long vagaId);

    // 📄 Lista todas as candidaturas de uma vaga (EMPRESA)
    List<Candidatura> findByVagaId(Long vagaId);

    // 📄 Lista todas as candidaturas de um aluno (ALUNO)
    List<Candidatura> findByAlunoId(Long alunoId);

    // 📄 Lista candidaturas por status (opcional, mas útil)
    List<Candidatura> findByStatus(String status);
}

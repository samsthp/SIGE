package com.sige.repository;

import com.sige.model.Estagio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstagioRepository extends JpaRepository<Estagio, Long> {
    // Busca todos os estágios de um aluno pelo ID
    List<Estagio> findByAluno_Id(Long alunoId);
}

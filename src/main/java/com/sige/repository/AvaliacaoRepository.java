package com.sige.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sige.model.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}

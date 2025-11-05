package com.sige.repository;

import com.sige.model.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {
    List<Candidatura> findByOfertaId(Long ofertaId);
}
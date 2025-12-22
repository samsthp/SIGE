package com.sige.service;

import com.sige.model.Candidatura;
import com.sige.model.StatusCandidatura;
import com.sige.repository.CandidaturaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidaturaService {

    private final CandidaturaRepository candidaturaRepository;

    public CandidaturaService(CandidaturaRepository candidaturaRepository) {
        this.candidaturaRepository = candidaturaRepository;
    }

    public Candidatura atualizarStatus(Long id, StatusCandidatura novoStatus) {
        Optional<Candidatura> candidaturaOpt = candidaturaRepository.findById(id);
        if (candidaturaOpt.isPresent()) {
            Candidatura candidatura = candidaturaOpt.get();
            candidatura.setStatus(novoStatus);
            return candidaturaRepository.save(candidatura);
        } else {
            throw new RuntimeException("Candidatura não encontrada com id " + id);
        }
    }
}

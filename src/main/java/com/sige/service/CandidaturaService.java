package com.sige.service;

import com.sige.model.Candidatura;
import com.sige.model.StatusCandidatura;
import com.sige.repository.CandidaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidaturaService {

    private final CandidaturaRepository candidaturaRepository;

    public CandidaturaService(CandidaturaRepository candidaturaRepository) {
        this.candidaturaRepository = candidaturaRepository;
    }

    // =========================
    // ACEITAR CANDIDATO
    // =========================
    public Candidatura aceitarCandidato(Long id) {
        Candidatura candidatura = buscarObrigatoria(id);
        candidatura.setStatus(StatusCandidatura.ACEITA);
        return candidaturaRepository.save(candidatura);
    }

    // =========================
    // RECUSAR CANDIDATO
    // =========================
    public Candidatura recusarCandidato(Long id) {
        Candidatura candidatura = buscarObrigatoria(id);
        candidatura.setStatus(StatusCandidatura.RECUSADA);
        return candidaturaRepository.save(candidatura);
    }

    // =========================
    // LISTAR POR VAGA
    // =========================
    public List<Candidatura> listarPorOferta(Long vagaId) {
        return candidaturaRepository.findByVagaId(vagaId);
    }

    // =========================
    // BUSCAR POR ID
    // =========================
    public Optional<Candidatura> buscarPorId(Long id) {
        return candidaturaRepository.findById(id);
    }

    // =========================
    // MÉTODO AUXILIAR
    // =========================
    private Candidatura buscarObrigatoria(Long id) {
        return candidaturaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Candidatura não encontrada com id " + id)
                );
    }
}

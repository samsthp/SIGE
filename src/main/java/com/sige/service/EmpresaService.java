package com.sige.service;

import com.sige.model.Candidatura;
import com.sige.model.StatusCandidatura;
import com.sige.repository.CandidaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    private final CandidaturaRepository candidaturaRepository;

    public EmpresaService(CandidaturaRepository candidaturaRepository) {
        this.candidaturaRepository = candidaturaRepository;
    }

    public Candidatura aceitarCandidato(Long id) {
        Candidatura c = candidaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidatura não encontrada"));
        c.setStatus(StatusCandidatura.ACEITA);
        return candidaturaRepository.save(c);
    }

    public Candidatura recusarCandidato(Long id) {
        Candidatura c = candidaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidatura não encontrada"));
        c.setStatus(StatusCandidatura.RECUSADA);
        return candidaturaRepository.save(c);
    }

    public List<Candidatura> listarCandidatosPorOferta(Long ofertaId) {
        return candidaturaRepository.findByOfertaId(ofertaId);
    }

    public Optional<Candidatura> buscarPorId(Long id) {
        return candidaturaRepository.findById(id);
    }
}

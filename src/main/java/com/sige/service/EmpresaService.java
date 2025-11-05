package com.sige.service;

import com.sige.model.Candidatura;
import com.sige.model.StatusCandidatura;
import com.sige.repository.CandidaturaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpresaService {

    private final CandidaturaRepository candidaturaRepository;

    public EmpresaService(CandidaturaRepository candidaturaRepository) {
        this.candidaturaRepository = candidaturaRepository;
    }

    public List<Candidatura> listarCandidatosPorOferta(Long ofertaId) {
        return candidaturaRepository.findByOfertaId(ofertaId);
    }

    public void aceitarCandidato(Long candidaturaId) {
        Candidatura candidatura = candidaturaRepository.findById(candidaturaId)
                .orElseThrow(() -> new RuntimeException("Candidatura não encontrada"));
        candidatura.setStatus(StatusCandidatura.ACEITA);
        candidaturaRepository.save(candidatura);
    }

    public void recusarCandidato(Long candidaturaId) {
        Candidatura candidatura = candidaturaRepository.findById(candidaturaId)
                .orElseThrow(() -> new RuntimeException("Candidatura não encontrada"));
        candidatura.setStatus(StatusCandidatura.RECUSADA);
        candidaturaRepository.save(candidatura);
    }
}

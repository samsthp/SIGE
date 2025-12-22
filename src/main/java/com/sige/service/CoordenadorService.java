package com.sige.service;

import com.sige.model.Candidatura;
import com.sige.model.Coordenador;
import com.sige.model.StatusCandidatura;
import com.sige.repository.CandidaturaRepository;
import com.sige.repository.CoordenadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordenadorService {

    private final CandidaturaRepository candidaturaRepository;
    private final CoordenadorRepository coordenadorRepository;

    public CoordenadorService(
            CandidaturaRepository candidaturaRepository,
            CoordenadorRepository coordenadorRepository
    ) {
        this.candidaturaRepository = candidaturaRepository;
        this.coordenadorRepository = coordenadorRepository;
    }

    // ================= ACEITAR / RECUSAR =================

    public Candidatura aceitarCandidato(Long id) {
        Candidatura c = candidaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidatura não encontrada"));

        if (c.getStatus() == StatusCandidatura.INSCRITO) {
            c.setStatus(StatusCandidatura.ACEITA);
        } else if (c.getStatus() == StatusCandidatura.ACEITA) {
            c.setStatus(StatusCandidatura.ATIVO);
        } else {
            throw new RuntimeException("Não é possível aceitar candidatura com status " + c.getStatus());
        }

        return candidaturaRepository.save(c);
    }

    public Candidatura recusarCandidato(Long id) {
        Candidatura c = candidaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidatura não encontrada"));
        c.setStatus(StatusCandidatura.RECUSADA);
        return candidaturaRepository.save(c);
    }

    // ================= LISTAGENS =================

    // ✅ CORRIGIDO — agora por VAGA
    public List<Candidatura> listarCandidatosPorVaga(Long vagaId) {
        return candidaturaRepository.findByVagaId(vagaId);
    }

    public List<Candidatura> listarTodos() {
        return candidaturaRepository.findAll();
    }

    public List<Candidatura> listarPorStatus(StatusCandidatura status) {
        return candidaturaRepository.findByStatus(status);
    }

    // ================= FLUXO DE ESTÁGIO =================

    public Candidatura ativarCandidato(Long id) {
        Candidatura c = candidaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidatura não encontrada"));

        if (c.getStatus() != StatusCandidatura.ACEITA) {
            throw new RuntimeException("Só é possível ativar candidatos ACEITOS");
        }

        c.setStatus(StatusCandidatura.ATIVO);
        return candidaturaRepository.save(c);
    }

    public Candidatura finalizarCandidato(Long id) {
        Candidatura c = candidaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidatura não encontrada"));

        if (c.getStatus() != StatusCandidatura.ATIVO) {
            throw new RuntimeException("Só é possível finalizar candidatos ATIVOS");
        }

        c.setStatus(StatusCandidatura.FINALIZADO);
        return candidaturaRepository.save(c);
    }

    // ================= COORDENADOR =================

    public Coordenador cadastrar(Coordenador coordenador) {
        return coordenadorRepository.save(coordenador);
    }
}

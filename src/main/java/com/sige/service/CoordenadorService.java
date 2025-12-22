package com.sige.service;

import com.sige.model.Candidatura;
import com.sige.model.Coordenador;
import com.sige.model.StatusCandidatura;
import com.sige.repository.CandidaturaRepository;
import com.sige.repository.CoordenadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordenadorService {

    private final CandidaturaRepository candidaturaRepository;
    private final CoordenadorRepository coordenadorRepository;

    public CoordenadorService(CandidaturaRepository candidaturaRepository,
                              CoordenadorRepository coordenadorRepository) {
        this.candidaturaRepository = candidaturaRepository;
        this.coordenadorRepository = coordenadorRepository;
    }
    

    // ✅ Mesmo que no EmpresaService
    public Candidatura aceitarCandidato(Long id) {
        Candidatura c = candidaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidatura não encontrada"));

        if (c.getStatus() == StatusCandidatura.INSCRITO) {
            // Primeira aceitação -> candidato foi aceito
            c.setStatus(StatusCandidatura.ACEITA);
        } else if (c.getStatus() == StatusCandidatura.ACEITA) {
            // Segunda aceitação -> estágio ativado
            c.setStatus(StatusCandidatura.ATIVO);
        } else {
            throw new RuntimeException("Não é possível aceitar um candidato com status " + c.getStatus());
        }

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

    // 🔹 NOVAS FUNÇÕES ESPECÍFICAS DO COORDENADOR 🔹

    // Ativar candidato aceito (inicia estágio)
    public Candidatura ativarCandidato(Long id) {
        Candidatura c = candidaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidatura não encontrada"));
        if (c.getStatus() != StatusCandidatura.ACEITA) {
            throw new RuntimeException("Só é possível ativar candidatos aceitos");
        }
        c.setStatus(StatusCandidatura.ATIVO);
        return candidaturaRepository.save(c);
    }

    // Finalizar estágio de um candidato ativo
    public Candidatura finalizarCandidato(Long id) {
        Candidatura c = candidaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidatura não encontrada"));
        if (c.getStatus() != StatusCandidatura.ATIVO) {
            throw new RuntimeException("Só é possível finalizar candidatos ativos");
        }
        c.setStatus(StatusCandidatura.FINALIZADO);
        return candidaturaRepository.save(c);
    }

    // Listar todos os candidatos do sistema
    public List<Candidatura> listarTodos() {
        return candidaturaRepository.findAll();
    }

    // Listar candidatos por status
    public List<Candidatura> listarPorStatus(StatusCandidatura status) {
        return candidaturaRepository.findByStatus(status);
    }

    public Coordenador cadastrar(Coordenador coordenador) {
        return coordenadorRepository.save(coordenador);
    }
}
package com.sige.service;

import com.sige.model.Estagio;
import com.sige.repository.EstagioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstagioService {

    private final EstagioRepository estagioRepository;

    public EstagioService(EstagioRepository estagioRepository) {
        this.estagioRepository = estagioRepository;
    }

    // Histórico completo do aluno
    public List<Estagio> listarHistorico(Long alunoId) {
        return estagioRepository.findByAluno_Id(alunoId);
    }

    // Estágio específico
    public Estagio acompanharEstagio(Long estagioId) {
        return estagioRepository.findById(estagioId)
                .orElseThrow(() -> new RuntimeException("Estágio não encontrado"));
    }

    // Estágios ATIVOS do aluno
    public List<Estagio> buscarAtivosPorAluno(Long alunoId) {
        return estagioRepository.findByAluno_IdAndStatus(alunoId, "ATIVO");
    }
}

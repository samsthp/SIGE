package com.sige.service;

import com.sige.model.Estagio;
import com.sige.repository.EstagioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstagioService {

    @Autowired
    private EstagioRepository estagioRepository;

    // Lista todos os estágios de um aluno
    public List<Estagio> listarHistorico(Long alunoId) {
        return estagioRepository.findByAluno_Id(alunoId);
    }

    // Busca um estágio específico
    public Estagio acompanharEstagio(Long estagioId) {
        return estagioRepository.findById(estagioId).orElse(null);
    }
}
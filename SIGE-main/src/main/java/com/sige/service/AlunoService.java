package com.sige.service;

import com.sige.model.Aluno;
import com.sige.repository.AlunoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public Aluno atualizar(Long id, Aluno dados) {

        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        aluno.setNome(dados.getNome());
        aluno.setEmail(dados.getEmail());
        aluno.setTelefone(dados.getTelefone());

        return repository.save(aluno);
    }
}

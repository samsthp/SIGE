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


    public Aluno buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }


    public Aluno atualizar(Long id, Aluno dados) {

        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        aluno.setNome(dados.getNome());
        aluno.setEmail(dados.getEmail());
        aluno.setTelefone(dados.getTelefone());
        aluno.setEndereco(dados.getEndereco());
        aluno.setFotoPerfil(dados.getFotoPerfil());

        if (dados.getSenha() != null && !dados.getSenha().isBlank()) {
            aluno.setSenha(dados.getSenha());
        }

        return repository.save(aluno);
    }
}

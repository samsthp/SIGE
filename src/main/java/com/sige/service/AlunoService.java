package com.sige.service;

import com.sige.dto.CadastroAlunoDTO;
import com.sige.model.Aluno;
import com.sige.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public void salvar(CadastroAlunoDTO dto) {
        if (existsByCpf(dto.getCpf())) {
            throw new RuntimeException("CPF já cadastrado");
        }

        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setCpf(dto.getCpf());
        aluno.setNascimento(dto.getNascimento());
        aluno.setMatricula(dto.getMatricula());
        aluno.setTelefone(dto.getTelefone());
        aluno.setEndereco(dto.getEndereco());
        aluno.setSenha(dto.getSenha());

        repository.save(aluno);
    }

    public boolean existsByCpf(String cpf) {
        return repository.existsByCpf(cpf);
    }
}
package com.sige.service.impl;

import com.sige.dto.CadastroAlunoDTO;
import com.sige.model.Aluno;
import com.sige.repository.AlunoRepository;
import com.sige.service.AlunoService;
import org.springframework.stereotype.Service;

@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository repository;

    public AlunoServiceImpl(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void salvar(CadastroAlunoDTO dto) {
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

    @Override
    public boolean existsByCpf(String cpf) {
        return repository.existsByCpf(cpf);
    }

    @Override
    public void enviarEmail(String para, String assunto, String texto) {
        // Aqui você pode usar JavaMailSender ou outro método real
        System.out.println("Enviando email para " + para + " - " + assunto);
    }
}

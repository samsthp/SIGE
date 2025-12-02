package com.sige.service;

import com.sige.model.Empresa;
import com.sige.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    public Empresa atualizar(Long id, Empresa dados) {
        Empresa empresa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        empresa.setNomeFantasia(dados.getNomeFantasia());
        empresa.setEmail(dados.getEmail());
        empresa.setTelefone(dados.getTelefone());
        empresa.setDescricao(dados.getDescricao());

        return repository.save(empresa);
    }
}

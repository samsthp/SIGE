package com.sige.service;

<<<<<<< HEAD
import com.sige.dto.CadastroEmpresaDTO;
import com.sige.model.Empresa;
import com.sige.repository.EmpresaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmpresaService {

    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    public void salvar(CadastroEmpresaDTO dto) {
        if (existsByCnpj(dto.getCnpj())) {
            throw new RuntimeException("CNPJ já cadastrado");
        }

        Empresa empresa = new Empresa();
        empresa.setNome(dto.getNome());
        empresa.setCnpj(dto.getCnpj());
        empresa.setEmail(dto.getEmail());
        empresa.setTelefone(dto.getTelefone());
        empresa.setEndereco(dto.getEndereco());
        empresa.setSenha(dto.getSenha());

        repository.save(empresa);
    }

    public boolean existsByCnpj(String cnpj) {
        return repository.existsByCnpj(cnpj);
    }
}

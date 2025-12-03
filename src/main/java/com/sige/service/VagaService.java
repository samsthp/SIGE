package com.sige.service;

import com.sige.dto.VagaDTO;
import com.sige.model.Empresa;
import com.sige.model.Vaga;
import com.sige.repository.EmpresaRepository;
import com.sige.repository.VagaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {

    private final VagaRepository vagaRepository;
    private final EmpresaRepository empresaRepository; 
  
    public VagaService(VagaRepository vagaRepository, EmpresaRepository empresaRepository) {
        this.vagaRepository = vagaRepository;
        this.empresaRepository = empresaRepository;
    }

    public Vaga salvar(VagaDTO dto) {
        Empresa empresa = empresaRepository.findById(dto.getEmpresaId())
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        Vaga vaga = new Vaga();
        vaga.setTitulo(dto.getTitulo());
        vaga.setDescricao(dto.getDescricao());
        vaga.setSalario(dto.getSalario());
        vaga.setRequisitos(dto.getRequisitos());
        vaga.setEmpresa(empresa);

        return vagaRepository.save(vaga);
    }
    public List<Vaga> listarTodas() {
        return vagaRepository.findAll();
    }

    public List<Vaga> buscarPorCurso(String curso) {
        return vagaRepository.findByCursoRelacionadoContainingIgnoreCase(curso);
    }

    public List<Vaga> buscarPorEstado(String estado) {
        return vagaRepository.findByEstadoContainingIgnoreCase(estado);
    }

    public List<Vaga> buscarPorEmpresa(String empresa) {
        return vagaRepository.findByEmpresaContainingIgnoreCase(empresa);
    }
}

package com.sige.service;

<<<<<<< HEAD
import com.sige.model.Vaga;
import com.sige.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    public List<Vaga> listarTodas() {
        return vagaRepository.findAll();
    }

    public List<Vaga> buscarPorCurso(String curso) {
        return vagaRepository.findByCursoRelacionadoContainingIgnoreCase(curso);
    }

    public List<Vaga> buscarPorEstado(String estado) {
        return vagaRepository.findByEstadoContainingIgnoreCase(estado);
    }

    public List<Vaga> buscarPorEmpresa(Long empresaId) {
        return vagaRepository.findByEmpresa_Id(empresaId);
    }

    public Vaga salvar(Vaga vaga) {
        return vagaRepository.save(vaga);
    }
}


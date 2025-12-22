package com.sige.service;

import com.sige.model.Usuario;
import com.sige.model.Vaga;
import com.sige.repository.UsuarioRepository;
import com.sige.repository.VagaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {

    private final VagaRepository vagaRepository;
    private final UsuarioRepository usuarioRepository;

    public VagaService(VagaRepository vagaRepository, UsuarioRepository usuarioRepository) {
        this.vagaRepository = vagaRepository;
        this.usuarioRepository = usuarioRepository;
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

    // ✅ CORRETO
    public List<Vaga> buscarPorEmpresa(Long empresaId) {
        Usuario empresa = usuarioRepository.findById(empresaId)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        return vagaRepository.findByEmpresa(empresa);
    }

    public Vaga salvar(Vaga vaga) {
        return vagaRepository.save(vaga);
    }
}

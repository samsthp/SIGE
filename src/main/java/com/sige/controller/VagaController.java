package com.sige.controller;

import com.sige.dto.VagaResponseDTO;
import com.sige.model.Usuario;
import com.sige.model.Vaga;
import com.sige.repository.CandidaturaRepository;
import com.sige.repository.UsuarioRepository;
import com.sige.repository.VagaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
@CrossOrigin(origins = "*")
public class VagaController {

    private final VagaRepository vagaRepository;
    private final UsuarioRepository usuarioRepository;
    private final CandidaturaRepository candidaturaRepository;

    public VagaController(
            VagaRepository vagaRepository,
            UsuarioRepository usuarioRepository,
            CandidaturaRepository candidaturaRepository
    ) {
        this.vagaRepository = vagaRepository;
        this.usuarioRepository = usuarioRepository;
        this.candidaturaRepository = candidaturaRepository;
    }

    @GetMapping
    public List<VagaResponseDTO> listarTodas() {
        return vagaRepository.findAll()
                .stream()
                .map(v -> new VagaResponseDTO(
                        v,
                        candidaturaRepository.countByVagaId(v.getId())
                ))
                .toList();
    }

    @GetMapping("/minhas")
    public List<VagaResponseDTO> minhasVagas() {

        String principal = SecurityContextHolder.getContext().getAuthentication().getName();

        Usuario empresa = usuarioRepository.findByPrincipal(principal)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        return vagaRepository.findByEmpresa(empresa)
                .stream()
                .map(v -> new VagaResponseDTO(
                        v,
                        candidaturaRepository.countByVagaId(v.getId())
                ))
                .toList();
    }

    @PostMapping("/publicar")
    public String publicar(@RequestBody Vaga vaga) {

        String principal = SecurityContextHolder.getContext().getAuthentication().getName();

        Usuario empresa = usuarioRepository.findByPrincipal(principal)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        vaga.setEmpresa(empresa);
        vagaRepository.save(vaga);

        return "Vaga publicada com sucesso";
    }
}

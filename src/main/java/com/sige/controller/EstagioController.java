package com.sige.controller;

import com.sige.dto.HistoricoDTO;
import com.sige.model.Estagio;
import com.sige.model.Usuario;
import com.sige.repository.UsuarioRepository;
import com.sige.service.EstagioService;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/estagios")
public class EstagioController {

    private final EstagioService estagioService;
    private final UsuarioRepository usuarioRepository;

    public EstagioController(
            EstagioService estagioService,
            UsuarioRepository usuarioRepository
    ) {
        this.estagioService = estagioService;
        this.usuarioRepository = usuarioRepository;
    }

    // ========================= HISTÓRICO DO ALUNO =========================
    @GetMapping("/historico/{alunoId}")
    public List<HistoricoDTO> listarHistorico(@PathVariable Long alunoId) {

        List<Estagio> estagios = estagioService.listarHistorico(alunoId);

        return estagios.stream()
                .map(HistoricoDTO::new)
                .collect(Collectors.toList());
    }

    // ========================= ACOMPANHAR ESTÁGIO =========================
    @GetMapping("/{estagioId}")
    public Estagio acompanharEstagio(@PathVariable Long estagioId) {
        return estagioService.acompanharEstagio(estagioId);
    }

    // ========================= ESTÁGIO ATIVO DO ALUNO LOGADO =========================
    @GetMapping("/meu")
    public List<Estagio> meuEstagio() {

        String principal = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        Usuario aluno = usuarioRepository.findByPrincipal(principal)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        return estagioService.buscarAtivosPorAluno(aluno.getId());
    }
}
